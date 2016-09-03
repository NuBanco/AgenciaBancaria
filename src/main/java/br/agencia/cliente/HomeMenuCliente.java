package br.agencia.cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HomeMenuCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7498261232620029833L;

	public HomeMenuCliente() {
		setBounds(100, 100, 480, 280);
		setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().setLayout(null);

		JButton btnOpSaque = new JButton("1 - Saques");
		btnOpSaque.setBackground(SystemColor.scrollbar);
		btnOpSaque.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpSaque.setBounds(35, 22, 180, 50);
		getContentPane().add(btnOpSaque);

		JButton btnOpSaldo = new JButton("2 - Saldo");
		btnOpSaldo.setBackground(SystemColor.scrollbar);
		btnOpSaldo.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpSaldo.setBounds(35, 97, 180, 50);
		getContentPane().add(btnOpSaldo);

		JButton btnOpDepositos = new JButton("3 - Depósitos");
		btnOpDepositos.setBackground(SystemColor.scrollbar);
		btnOpDepositos.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpDepositos.setBounds(35, 176, 180, 50);
		getContentPane().add(btnOpDepositos);

		JButton btnOpTransferencia = new JButton("4 - Transferências");
		btnOpTransferencia.setBackground(SystemColor.scrollbar);
		btnOpTransferencia.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpTransferencia.setBounds(245, 22, 180, 50);
		getContentPane().add(btnOpTransferencia);

		JButton btnOpPagamentos = new JButton("5 - Pagamentos");
		btnOpPagamentos.setBackground(SystemColor.scrollbar);
		btnOpPagamentos.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpPagamentos.setBounds(245, 97, 180, 50);
		getContentPane().add(btnOpPagamentos);

		JButton btnOpFinalizar = new JButton("6 - Finalizar");
		btnOpFinalizar.setBackground(SystemColor.scrollbar);
		btnOpFinalizar.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpFinalizar.setBounds(245, 176, 180, 50);
		getContentPane().add(btnOpFinalizar);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				HomeMenuCliente menuCliente = new HomeMenuCliente();
				menuCliente.setLocationRelativeTo(null);
				menuCliente.setVisible(true);
			}
		});
	}

}
