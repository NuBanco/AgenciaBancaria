package br.agencia.model.util;

import java.math.BigDecimal;

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.Pessoa;
import br.agencia.model.entidadesPersistidas.Usuario;
import br.agencia.model.enums.TipoMovimento;
import br.agencia.view.cliente.ConfirmaOperacao;
import br.agencia.view.cliente.HomeMenuCliente;
import br.agencia.view.cliente.SenhaCliente;
import br.agencia.view.principal.TelaBackground;

public class OperacoesFacade {

	private Conta contaOperacao;
	private Agencia agenciaOperacao;

	private void validarConta(final String conta, final int agencia) {
		this.contaOperacao = (Conta) ObjectDao.getObjectDao().consultarByQuery(
				String.format("from Conta where con_numero like '%s' and con_idagencia = %d", conta, agencia));

		if (contaOperacao == null) {
			throw new ContaInexistenteException("Conta nao cadastrada!");
		}

	}

	private void validarAgencia(final String agencia) {
		this.agenciaOperacao = (Agencia) ObjectDao.getObjectDao()
				.consultarByQuery(String.format("from Agencia where age_numAgencia like '%s'", agencia));
		if (agenciaOperacao == null) {
			throw new AgencaInexistenteException("Agencia nao cadastrada!");
		}
	}

	private void validarSaldo(BigDecimal valor) throws SaldoInsuficienteException {
		if (Math.abs(valor.doubleValue()) > contaOperacao.getSaldo().doubleValue()) {
			throw new SaldoInsuficienteException("Saldo insuficiente para operacao");
		}
	}

	private void atualizarSaldo(Conta conta, BigDecimal valor, TipoMovimento tipo) {
		if (conta.getId() != UsuarioLogado.getContaUsuarioLogado().getId()) {
			UsuarioLogado.getContaUsuarioLogado().setSaldo(valor.multiply(new BigDecimal(-1)), tipo);
		}
		if (tipo.equals(TipoMovimento.DEPOSITO) && conta.getId() == UsuarioLogado.getContaUsuarioLogado().getId()) {
			UsuarioLogado.getContaUsuarioLogado().setSaldo(valor, tipo);
		} else {
			conta.setSaldo(valor, tipo);
		}
	}

	public void sacar(String agencia, String conta, BigDecimal valorSaque) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		validarSaldo(valorSaque);
	}

	public void depositar(String agencia, String conta, BigDecimal valorDeposito) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		atualizarSaldo(contaOperacao, valorDeposito, TipoMovimento.DEPOSITO);
	}

	public void pagar(String agencia, String conta, BigDecimal valorPagamento) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		validarSaldo(valorPagamento);
	}

	public void transferir(String agencia, String conta, BigDecimal valorTransferencia) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(UsuarioLogado.getContaUsuarioLogado().getNumero(),
				UsuarioLogado.getContaUsuarioLogado().getAgencia().getId());
		validarSaldo(valorTransferencia);
		validarConta(conta, agenciaOperacao.getId());
	}

	public void validarSenha(Conta conta, String senha, BigDecimal valor, TipoMovimento tipo) {
		if (!UsuarioLogado.getUsuarioLogado().getPessoa().getSenhaOperacao().equals(senha)) {
			throw new SenhaInvalidaException("Senha de operacoes invalida.");
		}
		atualizarSaldo(conta, valor, TipoMovimento.TRANSFERENCIA);
	}

	public void criarConta(Pessoa novaPessoa, Usuario novoUsuario, Conta novaConta) {
		ObjectDao.getObjectDao().incluir(novaPessoa);
		ObjectDao.getObjectDao().incluir(novoUsuario);
		ObjectDao.getObjectDao().incluir(novaConta);
	}

	public void adaptarBancario(String agencia, String conta) {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		UsuarioLogado.SetContaUsuarioLogado(contaOperacao);

		TelaBackground.clearPanelMenu();
		TelaBackground.getPanelMenu().add(new HomeMenuCliente());
	}
}
