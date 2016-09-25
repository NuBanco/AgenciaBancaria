package br.agencia.view.principal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.model.entidadesPersistidas.Usuario;
import br.agencia.model.enums.TipoUsuario;
import br.agencia.model.util.UsuarioLogado;

public class TelaBackground extends JFrame {

	private static final long serialVersionUID = -4312697814718930403L;

	private static JFrame telaPrincipal;
	private static JLabel dataHoje;
	private static JLabel horaAtual;	
	private static JLabel lbAgencia;
	private static JLabel lbTipoConta;
	private static JLabel lbSaldo;
	private static JLabel lbResutSaldo;
	private static JLabel lbResultAgencia;
	private static JLabel lbResultConta;
	

	protected static JPanel panelMenu = new JPanel();

	public static JFrame getTelaPrincipal() {
		if (telaPrincipal == null) {
			telaPrincipal = new TelaBackground();
		}
		configuraCabecalhoPadrao();
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
		panel.setSize(700, 250);

		JLabel lbLogo = new JLabel(logo);

		dataHoje = new JLabel("data");
		dataHoje.setFont(new Font("Arial", Font.BOLD, 16));

		dataHoje.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));

		horaAtual = new JLabel("");
		horaAtual.setFont(new Font("Arial", Font.BOLD, 16));
		horaAtual.setText(new SimpleDateFormat("hh:MM").format(new Date(System.currentTimeMillis())));

		JLabel lbDescricao = new JLabel("Um dia fica pronto");
		lbDescricao.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDescricao.setEnabled(false);

		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lbTitulo = new JLabel("BANCO TADS");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 26));

		lbAgencia = new JLabel("Ag\u00EAncia     :");
		lbAgencia.setFont(new Font("Arial", Font.BOLD, 16));

		lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.BOLD, 16));

		lbSaldo = new JLabel("Saldo          :");
		lbSaldo.setFont(new Font("Arial", Font.BOLD, 16));

		lbResultAgencia = new JLabel();
		lbResultAgencia.setFont(new Font("Arial", Font.BOLD, 16));
		lbResultConta = new JLabel();
		lbResultConta.setFont(new Font("Arial", Font.BOLD, 16));
		lbResutSaldo = new JLabel();
		lbResutSaldo.setFont(new Font("Arial", Font.BOLD, 16));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lbLogo, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbTitulo, Alignment.TRAILING).addGroup(gl_panel
												.createSequentialGroup().addComponent(lbDescricao).addPreferredGap(
														ComponentPlacement.RELATED, 60, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lbAgencia).addGap(18).addComponent(lbResultAgencia))
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lbTipoConta)
												.addGap(18).addComponent(lbResultConta))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lbSaldo).addGap(18)
												.addComponent(lbResutSaldo)))
								.addGap(45))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup().addComponent(dataHoje)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(horaAtual).addGap(37)))));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(dataHoje).addComponent(horaAtual))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup().addGap(23)
														.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lbResultAgencia).addComponent(lbAgencia))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lbResultConta).addComponent(lbTipoConta))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lbSaldo).addComponent(lbResutSaldo)))
												.addGroup(gl_panel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED).addGroup(
																gl_panel.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addComponent(lbTitulo)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(lbDescricao))
																		.addComponent(lbLogo,
																				GroupLayout.PREFERRED_SIZE, 92,
																				GroupLayout.PREFERRED_SIZE))))
										.addGap(45)));
		gl_panel.setHonorsVisibility(false);
		panel.setLayout(gl_panel);

		getContentPane().add(getPanelMenu(), BorderLayout.CENTER);
		panelMenu.setLayout(null);
	}

	public static void configuraCabecalhoPadrao() {

		Usuario tipoUsuario = new Usuario();
		tipoUsuario = UsuarioLogado.getUsuarioLogado();

		if (tipoUsuario.getTipoUsuario() == TipoUsuario.BANCARIO) {
			lbAgencia.setVisible(false);
			lbTipoConta.setVisible(false);
			lbSaldo.setVisible(false);
			lbResutSaldo.setVisible(false);
			lbResultConta.setVisible(false);
			lbResultAgencia.setVisible(false);
		}

	}

}
