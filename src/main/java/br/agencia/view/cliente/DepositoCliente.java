package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.agencia.view.principal.TelaBackground;

public class DepositoCliente extends JPanel {

	private static final long serialVersionUID = 242114627222497452L;
	private JTextField tfAgencia;
	private JTextField tfConta;
	private JTextField tfTitular;

	public DepositoCliente() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbValorDeposito = new JLabel("Informe o valor a ser depositado:");
		lbValorDeposito.setFont(new Font("Arial", Font.BOLD, 16));

		JCheckBox chkContaLogada = new JCheckBox("Conta logada");
		chkContaLogada.setFont(new Font("Arial", Font.BOLD, 16));
		chkContaLogada.setSelected(true);

		JFormattedTextField tfValor = new JFormattedTextField();
		tfValor.setFont(new Font("Arial", Font.PLAIN, 16));
		tfValor.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lbAg = new JLabel("Ag\u00EAncia:");
		lbAg.setFont(new Font("Arial", Font.BOLD, 16));

		tfAgencia = new JTextField();
		tfAgencia.setFont(new Font("Arial", Font.PLAIN, 16));
		tfAgencia.setColumns(10);

		tfConta = new JTextField();
		tfConta.setFont(new Font("Arial", Font.PLAIN, 16));
		tfConta.setColumns(10);

		JLabel lbConta = new JLabel("Conta:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.BOLD, 16));

		JComboBox<String> cbbTipoConta = new JComboBox<String>();
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 16));
		cbbTipoConta.setMaximumRowCount(3);
		cbbTipoConta.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Conta Corrente", "Conta Poupan\u00E7a", "Conta Eletr\u00F4nica" }));
		cbbTipoConta.setSelectedIndex(0);

		JButton btnConfirmar = new JButton("Confirme");
		btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lbTitular = new JLabel("Titular:");
		lbTitular.setFont(new Font("Arial", Font.BOLD, 16));

		tfTitular = new JTextField();
		tfTitular.setFont(new Font("Arial", Font.PLAIN, 16));
		tfTitular.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap(458, Short.MAX_VALUE)
										.addComponent(btnVoltar).addGap(18).addComponent(btnConfirmar).addGap(40))
								.addGroup(Alignment.LEADING, groupLayout
										.createSequentialGroup().addGap(28)
										.addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING).addGroup(
														groupLayout.createSequentialGroup().addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING)
																.addComponent(lbAg).addComponent(tfAgencia,
																		GroupLayout.PREFERRED_SIZE, 196,
																		GroupLayout.PREFERRED_SIZE))
																.addGap(18)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(lbConta,
																						GroupLayout.PREFERRED_SIZE, 73,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED, 148,
																						Short.MAX_VALUE))
																		.addComponent(tfConta,
																				GroupLayout.DEFAULT_SIZE, 221,
																				Short.MAX_VALUE)))
												.addGroup(Alignment.TRAILING,
														groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lbTipoConta)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lbTitular).addPreferredGap(
																				ComponentPlacement.RELATED, 381,
																				GroupLayout.PREFERRED_SIZE))
																.addComponent(tfTitular, 435, 435, 435)
																.addComponent(chkContaLogada)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lbValorDeposito).addGap(18)
																		.addComponent(tfValor, GroupLayout.DEFAULT_SIZE,
																				166, Short.MAX_VALUE))
																.addComponent(cbbTipoConta, 0, 435, Short.MAX_VALUE)))
										.addGap(237)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(38)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lbValorDeposito).addComponent(
						tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(chkContaLogada).addGap(18)
								.addComponent(lbAg).addPreferredGap(ComponentPlacement.RELATED).addComponent(tfAgencia,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lbConta)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(tfConta,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(33).addComponent(lbTipoConta).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(27).addComponent(lbTitular).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(tfTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(24).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnConfirmar)
						.addComponent(btnVoltar))
				.addContainerGap(49, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
