package br.agencia.view.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.view.bancario.HomeMenuBancario;
import br.agencia.view.principal.TelaBackground;

public class ConfirmaOperacao extends JPanel {

	private static final long serialVersionUID = 3993718123138322069L;

	public ConfirmaOperacao(JFrame janela) {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		JLabel lbOperacao = new JLabel("Opera\u00E7\u00E3o $opera\u00E7\u00E3o realizada com sucesso!");
		lbOperacao.setFont(new Font("Arial", Font.PLAIN, 17));

		JLabel lbValor = new JLabel("Valor: R$ $valor");
		lbValor.setFont(new Font("Arial", Font.PLAIN, 17));

		JButton btnOpRetornar = new JButton("Retornar");
		btnOpRetornar.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			}
		});

		JButton btnOpImprimir = new JButton("");
		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
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
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

}
