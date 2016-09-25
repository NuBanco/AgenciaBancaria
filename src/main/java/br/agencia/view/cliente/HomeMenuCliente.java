package br.agencia.view.cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;

import br.agencia.view.principal.TelaBackground;

public class HomeMenuCliente extends JPanel {

	private static final long serialVersionUID = 5853409558338193456L;

	public HomeMenuCliente() {

		JButton btnOpSaque = new JButton("1 - Saque");
		btnOpSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new OpcoesSaque());
			}
		});
		btnOpSaque.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpSaldo = new JButton("2 - Saldo");
		btnOpSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new SaldoCliente());
			}
		});
		btnOpSaldo.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpDeposito = new JButton("3 - Dep\u00F3sitos");
		btnOpDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new DepositoCliente());
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
				TelaBackground.clearPanelMenu();
				createPanel(new PagamentoCliente());
			}
		});
		btnOpPagamento.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpTransferencia = new JButton("4 - Transfer\u00EAncias");
		btnOpTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new TransferenciaCliente());
			}
		});
		btnOpTransferencia.setFont(new Font("Arial", Font.BOLD, 17));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOpSaque, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(btnOpSaldo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOpDeposito, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addGap(124)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOpFinalizar, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(btnOpPagamento, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(btnOpTransferencia, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
					.addGap(102))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOpTransferencia, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOpSaque, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOpPagamento, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOpSaldo, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOpFinalizar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOpDeposito, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(96, Short.MAX_VALUE))
		);
//		TelaBackground.getPanelMenu().setLayout(groupLayout);
		setLayout(groupLayout);
	}

	private void createPanel(final JPanel panel) {
		panel.setSize(700, 450);
		panel.setVisible(true);
	}
}
