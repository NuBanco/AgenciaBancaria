package br.agencia.cliente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConfirmaOperacao extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3993718123138322069L;

	public ConfirmaOperacao() {

		JLabel lbOperacao = new JLabel("Opera\u00E7\u00E3o $opera\u00E7\u00E3o realizada com sucesso!");
		lbOperacao.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbValor = new JLabel("Valor: R$ $valor");
		lbValor.setFont(new Font("Arial", Font.PLAIN, 17));

		JButton btnOpRetornar = new JButton("Retornar");
		btnOpRetornar.setFont(new Font("Arial", Font.BOLD, 17));

		JButton btnOpImprimir = new JButton("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(33)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lbValor)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnOpRetornar, GroupLayout.PREFERRED_SIZE, 110,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lbOperacao))
						.addContainerGap(147, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(472, Short.MAX_VALUE)
								.addComponent(btnOpImprimir, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(55).addComponent(lbOperacao).addGap(32)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lbValor)
						.addComponent(btnOpRetornar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
				.addComponent(btnOpImprimir, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)));
		setLayout(groupLayout);
	}
}