package br.agencia;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaBackground extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = -4312697814718930403L;

	public TelaBackground(JPanel panelDinamico) {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eliel\\git\\AgenciaBancaria\\img\\banco-maizena-2.jpg"));
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 13));
		setBounds(100, 100, 700, 500);
		setTitle("Banco TADS");

		JLabel lblBancoTads = new JLabel("Banco TADS");
		lblBancoTads.setFont(new Font("Tahoma", Font.PLAIN, 35));

		JLabel lbDescricao = new JLabel("Aqui sua nota n\u00E3o vai ser zero");
		lbDescricao.setFont(new Font("Arial", Font.PLAIN, 25));

		JLabel lbNumeroAgencia = new JLabel("0000-00");
		lbNumeroAgencia.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lbNumeroConta = new JLabel("00000-00");
		lbNumeroConta.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lbSaldo = new JLabel("R$ 0,00");
		lbSaldo.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel = new JLabel("Saldo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lbAgencia = new JLabel("AG:");
		lbAgencia.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lbShData = new JLabel("01/08/2016 - 20:00");
		lbShData.setFont(new Font("Arial", Font.PLAIN, 13));

		JPanel panelMenu = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(panelMenu,
										GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE).addContainerGap())
								.addGroup(
										groupLayout.createSequentialGroup()
												.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 120,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
														groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblBancoTads).addComponent(lbDescricao))
												.addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout
														.createParallelGroup(Alignment.TRAILING).addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED,
																				521,
																				Short.MAX_VALUE)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(lbTipoConta)
																						.addComponent(lbAgencia)
																						.addComponent(lblNewLabel))
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								30, Short.MAX_VALUE)
																						.addGroup(groupLayout
																								.createParallelGroup(
																										Alignment.LEADING)
																								.addComponent(
																										lbNumeroAgencia,
																										Alignment.TRAILING)
																								.addComponent(
																										lbNumeroConta,
																										Alignment.TRAILING)))
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addPreferredGap(
																								ComponentPlacement.UNRELATED)
																						.addComponent(lbSaldo))))
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lbShData)))
												.addGap(66)))));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout
										.createSequentialGroup().addGroup(groupLayout.createParallelGroup(
												Alignment.LEADING)
												.addGroup(groupLayout
														.createSequentialGroup().addContainerGap().addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lbShData)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.BASELINE)
																				.addComponent(lbNumeroAgencia)
																				.addComponent(lbAgencia))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(lbNumeroConta)
																						.addComponent(lbTipoConta)))
																.addComponent(lblBancoTads))
														.addGap(8)
														.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblNewLabel).addComponent(lbSaldo)
																.addComponent(lbDescricao)))
												.addGroup(groupLayout.createSequentialGroup()
														.addGap(16).addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 103,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(16)
										.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
										.addContainerGap()));
		panelMenu.setLayout(new CardLayout(0, 0));
		panelMenu.add(panelDinamico);
		getContentPane().setLayout(groupLayout);
	}

	// public static void main(String[] args) {
	//
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// TelaBackground telaPadrao = new TelaBackground();
	// telaPadrao.setLocationRelativeTo(null);
	// telaPadrao.setVisible(true);
	// }
	// });
	// }
}
