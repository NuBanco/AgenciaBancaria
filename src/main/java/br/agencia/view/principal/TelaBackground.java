package br.agencia.view.principal;

import java.awt.CardLayout;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaBackground extends JFrame {

	private static final long serialVersionUID = -4312697814718930403L;

	public TelaBackground(JPanel panelDinamico) {
		ImageIcon logo = new ImageIcon("img\\logo.jpg");
		setTitle("Banco Tads");

		JLabel lbTitulo = new JLabel("BANCO TADS");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 26));

		JLabel lbDescricao = new JLabel("Um dia fica pronto");
		lbDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDescricao.setEnabled(false);

		JPanel panelDivisor = new JPanel();

		JPanel panelMenu = new JPanel();

		JLabel dataHoje = new JLabel("data");
		dataHoje.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel horaAgora = new JLabel("New label");
		horaAgora.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lblLogo = new JLabel(logo);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(panelDivisor, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblLogo)
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lbTitulo)
									.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
									.addComponent(dataHoje)
									.addGap(18)
									.addComponent(horaAgora)
									.addGap(11))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lbDescricao)
									.addContainerGap(211, Short.MAX_VALUE))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbTitulo)
								.addComponent(lblLogo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbDescricao))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(dataHoje)
							.addComponent(horaAgora)))
					.addGap(29)
					.addComponent(panelDivisor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelMenu, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
					.addContainerGap())
		);
		dataHoje.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
		horaAgora.setText(new SimpleDateFormat("hh:MM").format(new Date(System.currentTimeMillis())));

		panelMenu.setLayout(new CardLayout(0, 0));
		panelMenu.add(panelDinamico);
		getContentPane().setLayout(groupLayout);
	}
}
