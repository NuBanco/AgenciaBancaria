package br.agencia.view.bancario;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InformacoesConta extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8293231784772338084L;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	public static final String ID = "INFCONTA";

	public InformacoesConta() {

		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAgencia.setColumns(10);

		JLabel lbAgncia = new JLabel("AG:");
		lbAgncia.setFont(new Font("Arial", Font.BOLD, 14));

		txtConta = new JTextField();
		txtConta.setFont(new Font("Arial", Font.PLAIN, 14));
		txtConta.setColumns(10);

		JLabel lbConta = new JLabel("Conta:");
		lbConta.setFont(new Font("Arial", Font.BOLD, 14));

		JComboBox<String> cbbTipoConta = new JComboBox<String>();
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.BOLD, 14));

		txtTitular = new JTextField();
		txtTitular.setColumns(10);

		JButton btnConfirme = new JButton("Confirme");
		btnConfirme.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(30).addGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(btnConfirme)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtTitular, Alignment.LEADING)
										.addComponent(lbTipoConta, Alignment.LEADING).addComponent(cbbTipoConta,
												Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, groupLayout
												.createSequentialGroup().addGroup(groupLayout
														.createParallelGroup(Alignment.LEADING)
														.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lbAgncia))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lbConta)
														.addComponent(txtConta, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblTitular, Alignment.LEADING)))
				.addContainerGap(34, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(29)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbAgncia)
								.addComponent(lbConta))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lbTipoConta).addGap(3)
						.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblTitular).addGap(2)
						.addComponent(txtTitular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnConfirme).addContainerGap(32, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
	}
}
