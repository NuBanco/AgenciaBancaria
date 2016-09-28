package br.agencia.view.cliente;

import java.math.BigDecimal;
import java.util.Observer;

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.Agencia;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.enums.TipoMovimento;
import br.agencia.model.util.AgencaInexistenteException;
import br.agencia.model.util.ContaInexistenteException;
import br.agencia.model.util.SaldoInsuficienteException;
import br.agencia.model.util.UsuarioLogado;
import br.agencia.model.util.ValidacoesException;
import br.agencia.view.principal.TelaBackground;

public class ContaFacade {

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
		contaOperacao.setSaldo(valor, tipo);
		UsuarioLogado.getContaUsuarioLogado().notifyAll();
	}

	public void sacar(String agencia, String conta, BigDecimal valorSaque) throws ValidacoesException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		validarSaldo(valorSaque);
		atualizarSaldo(valorSaque.multiply(new BigDecimal(-1)), TipoMovimento.SAQUE);
	}

	public void depositar(String agencia, String conta, BigDecimal valorDeposito) throws SaldoInsuficienteException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		atualizarSaldo(valorDeposito, TipoMovimento.DEPOSITO);
	}

	public void pagar(String agencia, String conta, BigDecimal valorPagamento) throws SaldoInsuficienteException {
		validarAgencia(agencia);
		validarConta(conta, agenciaOperacao.getId());
		validarSaldo(valorPagamento);
		atualizarSaldo(valorPagamento, TipoMovimento.PAGAMENTO);
	}
}
