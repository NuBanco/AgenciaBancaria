package br.agencia.view.principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaBackground extends JFrame {

	private static final long serialVersionUID = -4312697814718930403L;

	private static JFrame telaPrincipal;
	protected static JPanel panelMenu = new JPanel();

	public static JFrame getTelaPrincipal() {
		if (telaPrincipal == null) {
			telaPrincipal = new TelaBackground();
		}
		return telaPrincipal;
	}

	public static JPanel getPanelMenu() {
		return panelMenu;
	}

	public static void clearPanelMenu() {
		getPanelMenu().setLayout(null);
		getPanelMenu().removeAll();
		getPanelMenu().updateUI();
	}

	public TelaBackground() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		JLabel lbTitulo = new JLabel("BANCO TADS");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 26));
		
		JLabel lblAgencia = new JLabel("Ag\u00EAncia     :");
		lblAgencia.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblTipoConta = new JLabel("Tipo Conta:");
		lblTipoConta.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblSaldo = new JLabel("Saldo         :");
		lblSaldo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbTitulo, Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbDescricao)
							.addPreferredGap(ComponentPlacement.RELATED, 60, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(145)
							.addComponent(dataHoje)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(horaAgora)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAgencia)
									.addGap(18)
									.addComponent(lblNewLabel_3))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblTipoConta)
									.addGap(18)
									.addComponent(lblNewLabel_4))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblSaldo)
									.addGap(18)
									.addComponent(lblNewLabel_5)))
							.addGap(45))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(dataHoje)
								.addComponent(horaAgora))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAgencia)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipoConta)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSaldo)
								.addComponent(lblNewLabel_5)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lbTitulo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbDescricao)))))
					.addGap(45))
		);
		gl_panel.setHonorsVisibility(false);
		panel.setLayout(gl_panel);

		getContentPane().add(getPanelMenu(), BorderLayout.CENTER);
		panelMenu.setLayout(null);
	}
}
