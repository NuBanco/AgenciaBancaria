package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;

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
	public static final String ID = "DEPOSITOCLIENTE";
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;

	public DepositoCliente() {
		
		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbValorDeposito = new JLabel("Informe o valor a ser depositado:");
		lbValorDeposito.setFont(new Font("Arial", Font.PLAIN, 14));

		JCheckBox chkContaLogada = new JCheckBox("Conta logada");
		chkContaLogada.setFont(new Font("Arial", Font.PLAIN, 14));
		chkContaLogada.setSelected(true);

		JFormattedTextField txtValor = new JFormattedTextField();
		txtValor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setText("R$ 0,00");

		JLabel lblAg = new JLabel("AG:");
		lblAg.setFont(new Font("Arial", Font.PLAIN, 14));

		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAgencia.setColumns(10);

		txtConta = new JTextField();
		txtConta.setFont(new Font("Arial", Font.PLAIN, 14));
		txtConta.setColumns(10);

		JLabel lblConta = new JLabel("Conta:");
		lblConta.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblTipoConta = new JLabel("Tipo Conta:");
		lblTipoConta.setFont(new Font("Arial", Font.PLAIN, 14));

		JComboBox<String> cbbTipoConta = new JComboBox<String>();
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 14));
		cbbTipoConta.setMaximumRowCount(3);
		cbbTipoConta.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Conta Corrente", "Conta Poupan\u00E7a", "Conta Eletr\u00F4nica" }));
		cbbTipoConta.setSelectedIndex(0);

		JButton btnConfirme = new JButton("Confirme");
		btnConfirme.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setFont(new Font("Arial", Font.PLAIN, 14));

		txtTitular = new JTextField();
		txtTitular.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTitular.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblTitular).addContainerGap(406,
								Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtTitular, Alignment.LEADING)
										.addComponent(cbbTipoConta, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lbValorDeposito, Alignment.LEADING)
										.addComponent(chkContaLogada, Alignment.LEADING)
										.addComponent(lblTipoConta, Alignment.LEADING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblAg))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblConta, GroupLayout.PREFERRED_SIZE, 73,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, 100,
																GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnConfirme).addGap(315)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbValorDeposito)
								.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConfirme))
						.addGap(18).addComponent(chkContaLogada).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblAg)
								.addComponent(lblConta))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblTipoConta)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(15).addComponent(lblTitular)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtTitular,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(70, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
