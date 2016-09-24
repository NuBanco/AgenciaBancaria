package br.agencia.view.bancario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.control.GenericDao;
import br.agencia.model.Agencia;
import br.agencia.model.Usuario;
import br.agencia.view.principal.TelaBackground;

public class NovaConta extends JPanel {

	private static final long serialVersionUID = 5210607113046110764L;
	public static final String ID = "NOVACONTA";
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtCPF;
	private JTextField txtAgencia;
	private JPasswordField txtSenhaOperacoes;
	private JPasswordField txtSenhaConta;
	private JLabel lbSenhaOperacoes;
	private JTextField txtUsername;

	public NovaConta() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNome.setColumns(10);

		JLabel lbIdade = new JLabel("Idade:");
		lbIdade.setFont(new Font("Arial", Font.BOLD, 12));

		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIdade.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCPF.setColumns(10);

		JLabel lblUsername = new JLabel("CPF:");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lbAgencia = new JLabel("AG:");
		lbAgencia.setFont(new Font("Arial", Font.BOLD, 12));

		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAgencia.setColumns(10);

		JLabel lblTipoConta = new JLabel("Tipo Conta:");
		lblTipoConta.setFont(new Font("Arial", Font.BOLD, 12));

		JComboBox<String> cbbTipoConta = new JComboBox<String>();
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 14));
		cbbTipoConta.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Conta Corrente", "Conta Poupan\u00E7a", "Conta Sal\u00E1rio" }));
		cbbTipoConta.setSelectedIndex(0);
		cbbTipoConta.setMaximumRowCount(3);

		txtSenhaOperacoes = new JPasswordField();
		txtSenhaOperacoes.setFont(new Font("Arial", Font.PLAIN, 14));

		txtSenhaConta = new JPasswordField();
		txtSenhaConta.setFont(new Font("Arial", Font.PLAIN, 14));

		lbSenhaOperacoes = new JLabel("Senha opera\u00E7\u00F5es:");
		lbSenhaOperacoes.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lbSenhaConta = new JLabel("Senha Conta:");
		lbSenhaConta.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Arial", Font.BOLD, 12));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuBancario());
			}
		});

		JButton btnConfirme = new JButton("Confirmar");
		btnConfirme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validarInformacoes()) {
					JOptionPane.showMessageDialog(null, "parece que criou");
				}

			}
		});

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsername.setColumns(10);

		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setFont(new Font("Arial", Font.BOLD, 12));

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(21).addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout
														.createSequentialGroup()
														.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 399,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtSenhaConta, 185, 185, 185)
																		.addComponent(lbSenhaConta))
																.addGap(12)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lbSenhaOperacoes,
																				GroupLayout.PREFERRED_SIZE, 131,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(txtSenhaOperacoes, 202, 202, 202)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGap(10)
																				.addComponent(btnVoltar,
																						GroupLayout.PREFERRED_SIZE, 82,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(btnConfirme,
																						GroupLayout.PREFERRED_SIZE, 104,
																						GroupLayout.PREFERRED_SIZE)))
																.addContainerGap())
														.addGroup(groupLayout.createSequentialGroup()
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(lbNome)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(lbAgencia,
																								GroupLayout.PREFERRED_SIZE,
																								37,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(groupLayout
																								.createParallelGroup(
																										Alignment.TRAILING,
																										false)
																								.addComponent(
																										txtAgencia,
																										Alignment.LEADING)
																								.addComponent(txtIdade,
																										Alignment.LEADING,
																										GroupLayout.DEFAULT_SIZE,
																										173,
																										Short.MAX_VALUE))
																						.addComponent(lbIdade,
																								GroupLayout.PREFERRED_SIZE,
																								48,
																								GroupLayout.PREFERRED_SIZE))
																				.addGap(24)
																				.addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(lblTipoConta,
																								GroupLayout.PREFERRED_SIZE,
																								108,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(groupLayout
																								.createParallelGroup(
																										Alignment.LEADING,
																										false)
																								.addComponent(
																										lblUsername,
																										GroupLayout.PREFERRED_SIZE,
																										48,
																										GroupLayout.PREFERRED_SIZE)
																								.addGroup(groupLayout
																										.createParallelGroup(
																												Alignment.LEADING,
																												false)
																										.addComponent(
																												cbbTipoConta,
																												Alignment.TRAILING,
																												GroupLayout.PREFERRED_SIZE,
																												202,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												txtCPF,
																												202,
																												202,
																												202)))))
																		.addComponent(txtNome,
																				GroupLayout.PREFERRED_SIZE, 399,
																				GroupLayout.PREFERRED_SIZE))
																.addGap(38))
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblUsername_1).addContainerGap())))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5).addComponent(lbNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lbIdade)
								.addComponent(lblUsername))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lbAgencia)
								.addComponent(lblTipoConta))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblUsername_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGap(7).addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbSenhaConta)
								.addComponent(lbSenhaOperacoes))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSenhaConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSenhaOperacoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnConfirme, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(9)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

	protected boolean validarInformacoes() {
		if (txtNome.getText().length() == 0 || txtIdade.getText().length() == 0 || txtCPF.getText().length() == 0
				|| txtAgencia.getText().length() == 0 || txtUsername.getText().length() == 0
				|| txtSenhaOperacoes.getText().length() == 0 || txtSenhaConta.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
			return false;
		}

		Agencia agenciaValidar = (Agencia) GenericDao
				.consultarByString(String.format("from Agencia where age_numAgencia like '%s'", txtAgencia.getText()));

		if (agenciaValidar == null) {
			JOptionPane.showMessageDialog(null, "Agencia nao encontrada!");
			return false;
		}

		Usuario usuarioValidar = (Usuario) GenericDao
				.consultarByString("from Usuario where usu_login like '" + txtUsername.getText() + "'");

		if (usuarioValidar != null){
			JOptionPane.showMessageDialog(null, String.format("Usuario %s ja possui uma conta!", txtUsername.getText()));
			return false;
		}

		return true;
	}
}
