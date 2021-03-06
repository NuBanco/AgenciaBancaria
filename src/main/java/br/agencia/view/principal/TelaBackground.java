package br.agencia.view.principal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.Usuario;
import br.agencia.model.enums.TipoUsuario;
import br.agencia.model.util.JNumberFormatField;
import br.agencia.model.util.UsuarioLogado;

public class TelaBackground extends JFrame implements Observer {

	private static final long serialVersionUID = -4312697814718930403L;

	private static JFrame telaPrincipal;
	private static JLabel dataHoje;
	private static JLabel horaAtual;
	private static JLabel lbAgencia;
	private static JLabel lbTipoConta;
	private static JLabel lbSaldo;
	private static JNumberFormatField nfSaldo = null;
	private static JLabel lbResultSaldo;
	private static JLabel lbResultAgencia;
	private static JLabel lbResultConta;
	public static Conta contaCliente;

	protected static JPanel panelMenu = new JPanel();

	public TelaBackground() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (UsuarioLogado.getUsuarioLogado().getTipoUsuario().equals(TipoUsuario.CLIENTE)) {
			UsuarioLogado.getContaUsuarioLogado().addObserver(this);
		}

		ImageIcon logo = new ImageIcon("img\\logo.jpg");
		setTitle("Banco Tads");

		JPanel panel = new JPanel();
		panel.setSize(700, 200);

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

		nfSaldo = new JNumberFormatField(new DecimalFormat("R$ ###,###,##0.00")).setLimit(11);
		nfSaldo.setVisible(false);
		lbResultSaldo = new JLabel("");
		lbResultSaldo.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbDivisor = new JLabel("-");
		lbDivisor.setFont(new Font("Arial Black", Font.BOLD, 16));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lbLogo, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(
												lbTitulo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_panel
												.createSequentialGroup()
												.addComponent(lbDescricao, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(60)))
						.addGap(91)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbSaldo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel.createSequentialGroup().addGap(2).addComponent(
														lbAgencia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
												.addComponent(lbTipoConta, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbResultAgencia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												137, Short.MAX_VALUE)
										.addComponent(lbResultSaldo, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
										.addComponent(lbResultConta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137,
												Short.MAX_VALUE))
								.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup().addComponent(dataHoje)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lbDivisor)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(horaAtual)
										.addGap(24)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(25)
										.addComponent(lbTitulo).addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(lbDescricao))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(dataHoje).addComponent(horaAtual).addComponent(lbDivisor))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lbAgencia).addComponent(lbResultAgencia))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lbTipoConta).addComponent(lbResultConta))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lbSaldo)
												.addComponent(lbResultSaldo))
										.addGap(17))
								.addComponent(lbLogo, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel.setHonorsVisibility(false);
		panel.setLayout(gl_panel);

		getContentPane().add(getPanelMenu(), BorderLayout.CENTER);
	}

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

	public static void configuraCabecalhoPadrao() {
		if (UsuarioLogado.getContaUsuarioLogado() == null) {
			lbAgencia.setVisible(false);
			lbTipoConta.setVisible(false);
			lbSaldo.setVisible(false);
			lbResultConta.setVisible(false);
			lbResultAgencia.setVisible(false);
		} else {
			contaCliente = UsuarioLogado.getContaUsuarioLogado();
			lbResultAgencia.setText(contaCliente.getAgencia().getNumAgencia());
			lbResultConta.setText(contaCliente.getTipoConta().name());
			if (contaCliente.getSaldo() == null) {
				contaCliente.setSaldo(new BigDecimal(0F));
			}
			nfSaldo.setText(contaCliente.getSaldo().toString());
			lbResultSaldo.setText(nfSaldo.getText());
		}
	}

	@Override
	public void update(Observable observable, Object object) {
		if (observable instanceof Conta) {
			nfSaldo.setText(UsuarioLogado.getContaUsuarioLogado().getSaldo().toString());
			lbResultSaldo.setText(nfSaldo.getText());
			configuraCabecalhoPadrao();
		}

	}

}
