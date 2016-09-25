package br.agencia.view.bancario;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
import br.agencia.model.Conta;
import br.agencia.model.ContaFacade;
import br.agencia.model.EncodePasswordClient;
import br.agencia.model.Pessoa;
import br.agencia.model.Usuario;
import br.agencia.model.enums.TipoConta;
import br.agencia.model.enums.TipoUsuario;
import br.agencia.view.principal.TelaBackground;

public class NovoProfissional extends JPanel {

	private static final long serialVersionUID = 5210607113046110764L;
	public static final String ID = "NOVACONTA";
	private JTextField tfNome;
	private JTextField tfIdade;
	private JPasswordField tfSenhaOperacoes;
	private JPasswordField tfSenhaConta;
	private JLabel lbSenhaOperacoes;
	private JTextField tfUsername;

	Agencia agenciaValidar = null;

	public NovoProfissional() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 16));
		tfNome.setColumns(10);

		JLabel lbIdade = new JLabel("Idade:");
		lbIdade.setFont(new Font("Arial", Font.BOLD, 16));

		tfIdade = new JTextField();
		tfIdade.setFont(new Font("Arial", Font.PLAIN, 16));
		tfIdade.setColumns(10);

		tfSenhaOperacoes = new JPasswordField();
		tfSenhaOperacoes.setFont(new Font("Arial", Font.PLAIN, 16));

		tfSenhaConta = new JPasswordField();
		tfSenhaConta.setFont(new Font("Arial", Font.PLAIN, 16));

		lbSenhaOperacoes = new JLabel("Senha Opera\u00E7\u00F5es:");
		lbSenhaOperacoes.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbSenhaConta = new JLabel("Senha Conta:");
		lbSenhaConta.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Arial", Font.BOLD, 16));

		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		tfUsername.setColumns(10);

		JLabel lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaBackground.clearPanelMenu();
				TelaBackground.getPanelMenu().add(new HomeMenuBancario());

			}
		});

		JButton btnConfirme = new JButton("Confirmar");
		btnConfirme.setFont(new Font("Arial", Font.PLAIN, 18));
		btnConfirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validarInformacoes()) {

					Pessoa novaPessoa = new Pessoa();
					novaPessoa.setNome(tfNome.getText()).setIdade(Integer.parseInt(tfIdade.getText()))
							.setSenhaOperacao(tfSenhaOperacoes.getText());

					Usuario novoUsuario = new Usuario();
					novoUsuario.setLogin(tfUsername.getText())
							.setSenha(new EncodePasswordClient().encode(tfSenhaConta.getText()))
							.setTipoUsuario(TipoUsuario.CLIENTE).setPessoa(novaPessoa);
					Conta novaConta = new Conta();
					novaConta.setDataAbertura(new Date(System.currentTimeMillis())).setAgencia(agenciaValidar)
							.setPessoa(novaPessoa).setNumero(String.valueOf(getNumeroContaDisponivel()));

					new ContaFacade(novaPessoa, novoUsuario, novaConta);

					JOptionPane.showMessageDialog(null,
							String.format("Conta %s criada com sucesso!", novaConta.getNumero()));

					limparTela();
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(60)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(tfSenhaConta, GroupLayout.PREFERRED_SIZE, 254,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(lbSenhaConta)
												.addContainerGap())
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addComponent(lbUsername)
														.addContainerGap())
												.addGroup(groupLayout.createSequentialGroup().addComponent(lbNome)
														.addContainerGap())
												.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(tfUsername, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
																.addGroup(Alignment.LEADING, groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(tfNome, GroupLayout.DEFAULT_SIZE,
																				461, Short.MAX_VALUE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lbIdade,
																						GroupLayout.PREFERRED_SIZE, 48,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(tfIdade,
																						GroupLayout.DEFAULT_SIZE, 105,
																						Short.MAX_VALUE)))
																.addGroup(groupLayout.createSequentialGroup()
																		.addGap(280).addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(lbSenhaOperacoes,
																						GroupLayout.PREFERRED_SIZE, 155,
																						GroupLayout.PREFERRED_SIZE)
																				.addGroup(groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(groupLayout
																								.createSequentialGroup()
																								.addPreferredGap(
																										ComponentPlacement.RELATED,
																										96,
																										Short.MAX_VALUE)
																								.addComponent(btnVoltar)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(
																										btnConfirme))
																						.addComponent(tfSenhaOperacoes,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								292,
																								Short.MAX_VALUE)))))
														.addGap(68)))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(lbNome).addComponent(lbIdade))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(lbUsername, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbSenhaConta)
								.addComponent(lbSenhaOperacoes))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfSenhaConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(tfSenhaOperacoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConfirme, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(216, Short.MAX_VALUE)));
		setLayout(groupLayout);
		// TelaBackground.getPanelMenu().setLayout(groupLayout);
	}

	protected int getNumeroContaDisponivel() {
		int numeroConta = (int) (10000 * Math.random());
		Conta buscaConta = (Conta) GenericDao.getGenericDao()
				.consultarByString(String.format("from Conta where con_numero LIKE '%s'", numeroConta));

		if (buscaConta == null) {
			return numeroConta;
		}

		return getNumeroContaDisponivel();
	}

	protected void limparTela() {
		tfIdade.setText("");
		tfNome.setText("");
		tfSenhaConta.setText("");
		tfSenhaOperacoes.setText("");
		tfUsername.setText("");
	}

	protected boolean validarInformacoes() {
		if (tfNome.getText().length() == 0 || tfIdade.getText().length() == 0 || tfUsername.getText().length() == 0
				|| tfSenhaOperacoes.getText().length() == 0 || tfSenhaConta.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
			return false;
		}

		Usuario usuarioValidar = (Usuario) GenericDao
				.consultarByString("from Usuario where usu_login like '" + tfUsername.getText() + "'");

		if (usuarioValidar != null) {
			JOptionPane.showMessageDialog(null, String.format("Usuario %s ja possui uma conta!", tfUsername.getText()));
			return false;
		}

		if (tfSenhaOperacoes.getText().length() != 6) {
			JOptionPane.showMessageDialog(null, "A senha de operações do usuario deve possuir SEIS digitos!");
			return false;
		}

		return true;
	}
}