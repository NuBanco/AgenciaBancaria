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
		setTitle("Banco Tads");

		JLabel lbTitulo = new JLabel("BANCO TADS");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 26));

		JLabel lbDescricao = new JLabel("Um dia fica pronto");
		lbDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDescricao.setEnabled(false);

		JPanel panelDivisor = new JPanel();

		JPanel panelMenu = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 464,
																Short.MAX_VALUE)
														.addContainerGap())
												.addComponent(panelDivisor, GroupLayout.DEFAULT_SIZE, 474,
														Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup().addGap(99)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lbDescricao).addComponent(lbTitulo))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lbTitulo)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lbDescricao).addGap(29)
						.addComponent(panelDivisor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE).addContainerGap()));
		panelMenu.setLayout(new CardLayout(0, 0));
		panelMenu.add(panelDinamico);
		getContentPane().setLayout(groupLayout);
	}
}
