package br.agencia.view.cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import br.agencia.view.main.TelaBackground;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeMenuCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5853409558338193456L;

	public HomeMenuCliente() {
		// setBounds(100, 100, 480, 280);

		JButton btnOpSaque = new JButton("1 - Saque");
		btnOpSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground saque = new TelaBackground(new OpcoesSaque());
				saque.setSize(580, 470);
				saque.setLocationRelativeTo(null);
				saque.setVisible(true);
			}
		});
		btnOpSaque.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpSaldo = new JButton("2 - Saldo");
		btnOpSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnOpSaldo.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpDeposito = new JButton("3 - Dep\u00F3sitos");
		btnOpDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("CCCCCCC");
			}
		});
		btnOpDeposito.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpFinalizar = new JButton("6 - Finalizar");
		btnOpFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnOpFinalizar.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpPagamento = new JButton("5 - Pagamentos");
		btnOpPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnOpPagamento.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpTransferencia = new JButton("4 - Transfer\u00EAncias");
		btnOpTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnOpTransferencia.setFont(new Font("Arial", Font.BOLD, 17));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHonorsVisibility(false);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(28)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnOpSaque, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
								.addComponent(btnOpSaldo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnOpDeposito, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(124)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpFinalizar, GroupLayout.PREFERRED_SIZE, 180,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpPagamento, GroupLayout.PREFERRED_SIZE, 180,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpTransferencia, GroupLayout.PREFERRED_SIZE, 180,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpTransferencia, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpSaque, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGap(59)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpPagamento, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpSaldo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGap(56)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpFinalizar, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpDeposito, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// HomeMenuBancario menuBancario = new HomeMenuBancario();
	// menuBancario.setLocationRelativeTo(null);
	// menuBancario.setVisible(true);
	// }
	// });
	// }
}
