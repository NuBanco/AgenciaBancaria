package br.agencia;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class OpcoesSaque extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2914438307389368709L;

	public OpcoesSaque() {

		JButton btnOp50 = new JButton("R$ 50,00");
		btnOp50.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOp100 = new JButton("R$ 100,00");
		btnOp100.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOp500 = new JButton("R$ 500,00");
		btnOp500.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnConfirme = new JButton("Confirme");
		btnConfirme.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnOp300 = new JButton("R$ 300,00");
		btnOp300.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOp200 = new JButton("R$ 200,00");
		btnOp200.setFont(new Font("Arial", Font.BOLD, 17));

		JLabel lbValorEspecifico = new JLabel("Informe outro valor");
		lbValorEspecifico.setFont(new Font("Arial", Font.PLAIN, 14));

		JFormattedTextField txtValor = new JFormattedTextField();
		txtValor.setFont(new Font("Arial", Font.PLAIN, 13));
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setText("R$ 0,00");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnOp500, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOp100, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOp50, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
				.addGap(63)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(
										groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnOp300, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lbValorEspecifico).addGroup(groupLayout
																.createSequentialGroup()
																.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, 81,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(btnConfirme, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addGap(73))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnOp200, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(38)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOp50, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOp200, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOp100, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOp300, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lbValorEspecifico)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnConfirme)))
						.addComponent(btnOp500, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(99, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}
}
