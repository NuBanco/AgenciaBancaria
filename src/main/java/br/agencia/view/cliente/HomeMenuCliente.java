package br.agencia.view.cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.agencia.view.principal.TelaBackground;

public class HomeMenuCliente extends JPanel {

	private static final long serialVersionUID = 5853409558338193456L;

	public HomeMenuCliente() {
		JButton btnOpSaque = new JButton("1 - Saque");
		btnOpSaque.setBounds(83, 62, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpSaque);

		btnOpSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new OpcoesSaque());
			}
		});
		btnOpSaque.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpSaldo = new JButton("2 - Saldo");
		btnOpSaldo.setBounds(293, 116, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpSaldo);
		btnOpSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new SaldoCliente());
			}
		});
		btnOpSaldo.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpDeposito = new JButton("3 - Depositos");
		btnOpDeposito.setBounds(293, 176, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpDeposito);
		btnOpDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new DepositoCliente());
			}
		});
		btnOpDeposito.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpTransferencia = new JButton("4 - Transferencias");
		btnOpTransferencia.setBounds(83, 116, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpTransferencia);
		btnOpTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new TransferenciaCliente());
			}
		});
		btnOpTransferencia.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpPagamento = new JButton("5 - Pagamentos");
		btnOpPagamento.setBounds(293, 62, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpPagamento);
		btnOpPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				createPanel(new PagamentoCliente());
			}
		});
		btnOpPagamento.setFont(new Font("Arial", Font.BOLD, 23));

		JButton btnOpFinalizar = new JButton("6 - Finalizar");
		btnOpFinalizar.setBounds(83, 176, 180, 30);
		TelaBackground.getPanelMenu().add(btnOpFinalizar);
		btnOpFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOpFinalizar.setFont(new Font("Arial", Font.BOLD, 23));

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(82)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOpSaldo, GroupLayout.PREFERRED_SIZE, 199, Short.MAX_VALUE)
								.addComponent(btnOpDeposito, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(btnOpSaque, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
						.addGap(68)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnOpPagamento, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(btnOpTransferencia, GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
								.addComponent(btnOpFinalizar, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
						.addGap(90)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGap(98).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOpTransferencia, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOpSaque, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOpSaldo, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
								.addComponent(btnOpPagamento, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
						.addGap(41)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnOpDeposito, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOpFinalizar, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))
						.addGap(111)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
		TelaBackground.getPanelMenu().setVisible(true);
	}

	private void createPanel(final JPanel panel) {
		panel.setSize(700, 450);
		panel.setVisible(true);
	}

}
