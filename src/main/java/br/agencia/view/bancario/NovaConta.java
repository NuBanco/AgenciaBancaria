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

	public NovaConta() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNome.setColumns(10);

		JLabel lbIdade = new JLabel("Idade:");
		lbIdade.setFont(new Font("Arial", Font.BOLD, 14));

		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Arial", Font.PLAIN, 14));
		txtIdade.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCPF.setColumns(10);

		JLabel lblUsername = new JLabel("CPF:");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbAgencia = new JLabel("AG:");
		lbAgencia.setFont(new Font("Arial", Font.BOLD, 14));

		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("Arial", Font.PLAIN, 14));
		txtAgencia.setColumns(10);

		JLabel lblTipoConta = new JLabel("Tipo Conta:");
		lblTipoConta.setFont(new Font("Arial", Font.BOLD, 14));

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
		lbSenhaOperacoes.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbSenhaConta = new JLabel("Senha Conta:");
		lbSenhaConta.setFont(new Font("Arial", Font.BOLD, 14));

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Arial", Font.BOLD, 14));

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
					// prossegue;
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
						groupLayout
								.createSequentialGroup().addGap(
										21)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout
												.createSequentialGroup().addGroup(
														groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lbSenhaConta)
																.addComponent(lbAgencia, GroupLayout.PREFERRED_SIZE, 37,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lbIdade,
																		GroupLayout.PREFERRED_SIZE, 48,
																		GroupLayout.PREFERRED_SIZE)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(txtSenhaConta, Alignment.LEADING)
																		.addComponent(txtAgencia, Alignment.LEADING)
																		.addComponent(txtIdade, Alignment.LEADING,
																				GroupLayout.DEFAULT_SIZE, 173,
																				Short.MAX_VALUE)))
												.addGap(18)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lbSenhaOperacoes, GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblTipoConta, GroupLayout.PREFERRED_SIZE, 108,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 48,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.TRAILING, false)
																.addGroup(groupLayout.createSequentialGroup().addGap(10)
																		.addComponent(btnVoltar,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnConfirme,
																				GroupLayout.PREFERRED_SIZE, 104,
																				GroupLayout.PREFERRED_SIZE))
																.addComponent(cbbTipoConta, 0, 202, Short.MAX_VALUE)
																.addComponent(txtCPF).addComponent(txtSenhaOperacoes))))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lbNome).addComponent(txtNome, GroupLayout.PREFERRED_SIZE,
														390, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(17).addComponent(lbNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbIdade)
								.addComponent(lblUsername))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lbAgencia)
								.addComponent(lblTipoConta))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbSenhaConta)
								.addComponent(lbSenhaOperacoes))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSenhaConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSenhaOperacoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConfirme, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(22, Short.MAX_VALUE)));
		TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

	protected boolean validarInformacoes() {
		if (txtNome.getText().length() == 0 || txtIdade.getText().length() == 0 || txtCPF.getText().length() == 0
				|| txtAgencia.getText().length() == 0 || txtSenhaOperacoes.getText().length() == 0
				|| txtSenhaConta.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
			return false;
		}

		Agencia agenciaValidar = (Agencia) GenericDao.find("from Agencia where ag_codAgencia like '" + txtAgencia.getText() + "'");

		if (agenciaValidar == null) {
			JOptionPane.showMessageDialog(null, "Agencia nao encontrada!");
			return false;
		}

		Usuario usuarioValidar = (Usuario) GenericDao.find("from Usuario where usu_login like '" + txtNome.getText() + "'");


		JOptionPane.showMessageDialog(null, usuarioValidar.getLogin());
		return true;
	}
}
