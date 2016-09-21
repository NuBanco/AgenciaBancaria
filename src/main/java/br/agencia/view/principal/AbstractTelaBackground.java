package br.agencia.view.principal;

import java.awt.CardLayout;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public abstract class AbstractTelaBackground extends JFrame {

	private static final long serialVersionUID = -4312697814718930403L;
	protected JPanel panelMenu = new JPanel();

	public abstract JPanel getPanelMenu();

	public AbstractTelaBackground() {

		ImageIcon logo = new ImageIcon("img\\logo.jpg");
		setTitle("Banco Tads");

		JPanel panel = new JPanel();
		panel.setSize(500, 250);

		JLabel lblLogo = new JLabel(logo);

		JLabel dataHoje = new JLabel("data");
		dataHoje.setFont(new Font("Arial", Font.BOLD, 14));

		dataHoje.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));

		JLabel horaAgora = new JLabel("New label");
		horaAgora.setFont(new Font("Arial", Font.BOLD, 14));
		horaAgora.setText(new SimpleDateFormat("hh:MM").format(new Date(System.currentTimeMillis())));

		JLabel lbDescricao = new JLabel("Um dia fica pronto");
		lbDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDescricao.setEnabled(false);

		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lbTitulo = new JLabel("BANCO TADS");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 26));
		panel.add(lbTitulo);
		panel.add(lblLogo);

		JLabel label = new JLabel("");
		panel.add(label);

		JLabel label_1 = new JLabel("");
		panel.add(label_1);

		JLabel label_2 = new JLabel("");
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		panel.add(label_3);
		panel.add(dataHoje);
		panel.add(horaAgora);
		panel.add(lbDescricao);
	}
}
