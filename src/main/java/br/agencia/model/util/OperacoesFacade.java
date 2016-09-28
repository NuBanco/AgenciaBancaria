package br.agencia.model.util;

import java.math.BigDecimal;
import java.util.Observer;

import com.sun.glass.ui.GestureSupport;

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.Pessoa;
import br.agencia.model.entidadesPersistidas.Usuario;
import br.agencia.model.enums.TipoMovimento;
import br.agencia.view.principal.TelaBackground;

public class OperacoesFacade {

	private Conta contaOperacao;
	private Agencia agenciaOperacao;

	public void validarConta(final String conta, final int agencia) {
		this.contaOperacao = (Conta) ObjectDao.getObjectDao().consultarByQuery(
				String.format("from Conta where con_numero like '%s' and con_idagencia = %d", conta, agencia));

		if (contaOperacao == null) {
			throw new ContaInexistenteException("Conta nao cadastrada!");
		}

	}

	public void validarAgencia(final String agencia) {
		this.agenciaOperacao = (Agencia) ObjectDao.getObjectDao()
				.consultarByQuery(String.format("from Agencia where age_numAgencia like '%s'", agencia));
		if (agenciaOperacao == null) {
			throw new AgencaInexistenteException("Agencia nao cadastrada!");
		}
	}

	public void validarSaldo(BigDecimal valor) throws SaldoInsuficienteException {
		if (Math.abs(valor.doubleValue()) > contaOperacao.getSaldo().doubleValue()) {
			throw new SaldoInsuficienteException("Saldo insuficiente para operacao");
		}
	}

	public void atualizarSaldo(BigDecimal valor, TipoMovimento tipo) {
		if (contaOperacao.getId() == UsuarioLogado.getContaUsuarioLogado().getId()){
			UsuarioLogado.getContaUsuarioLogado().setSaldo(valor, tipo);
		} else {
			contaOperacao.setSaldo(valor, tipo);
		}
	}

	public void sacar(String agencia, String conta, BigDecimal valorSaque) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		validarSaldo(valorSaque);
		atualizarSaldo(valorSaque.multiply(new BigDecimal(-1)), TipoMovimento.SAQUE);
	}

	public void depositar(String agencia, String conta, BigDecimal valorDeposito) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		atualizarSaldo(valorDeposito, TipoMovimento.DEPOSITO);
	}

	public void pagar(String agencia, String conta, BigDecimal valorPagamento) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		validarSaldo(valorPagamento);
		atualizarSaldo(valorPagamento, TipoMovimento.PAGAMENTO);
	}

	public void transferir(String agencia, String conta, BigDecimal valorPagamento) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		validarSaldo(valorPagamento);
		atualizarSaldo(valorPagamento, TipoMovimento.PAGAMENTO);
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
	}
}
