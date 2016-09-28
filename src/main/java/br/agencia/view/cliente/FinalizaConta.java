package br.agencia.view.cliente;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import br.agencia.control.ObjectDao;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.enums.SituacaoConta;
import br.agencia.model.util.UsuarioLogado;

public class FinalizaConta {

	public static Conta contaCliente;

	public FinalizaConta() {

		contaCliente = UsuarioLogado.getContaUsuarioLogado();
		if (contaCliente.getSaldo().compareTo(new BigDecimal("0.00")) > 0) {
			JOptionPane.showMessageDialog(null,
					"Voc� possui um cr�dito em conta no valor de R$: " + (contaCliente.getSaldo())
							+ (" . \n Para finalizar essa conta � necess�rio ter saldo zerado."),
					"Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (contaCliente.getSaldo().compareTo(new BigDecimal("0.00")) < 0) {
			JOptionPane.showMessageDialog(null,
					"Voc� possui um saldo devedor em conta no valor de R$: " + (contaCliente.getSaldo())
							+ (" . \n Para finalizar essa conta � necess�rio ter saldo zerado."),
					"Alerta", JOptionPane.WARNING_MESSAGE);
		} else {
			UsuarioLogado.getContaUsuarioLogado().setSituacaoConta(SituacaoConta.INATIVA);
			ObjectDao.getObjectDao().alterar(UsuarioLogado.getContaUsuarioLogado());
			JOptionPane.showMessageDialog(null,
					"Conta " + contaCliente.getNumero().toString() + " finalizada com sucesso.");
			System.exit(0);
		}
	}
}
