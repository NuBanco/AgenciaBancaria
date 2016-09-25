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

public class NovaConta extends JPanel {

	private static final long serialVersionUID = 5210607113046110764L;
	public static final String ID = "NOVACONTA";
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfCPF;
	private JTextField tfAgencia;
	private JPasswordField tfSenhaOperacoes;
	private JPasswordField tfSenhaConta;
	private JLabel lbSenhaOperacoes;
	private JTextField tfUsername;
	private JComboBox<String> cbbTipoConta;

	Agencia agenciaValidar = null;

	public NovaConta() {

		TelaBackground.getPanelMenu().add(new JPanel(), BorderLayout.CENTER);

		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 16));
		tfNome.setColumns(10);

		JLabel lbIdade = new JLabel("Idade:");
		lbIdade.setFont(new Font("Arial", Font.BOLD, 16));

		tfIdade = new JTextField();
		tfIdade.setFont(new Font("Arial", Font.PLAIN, 16));
		tfIdade.setColumns(10);

		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Arial", Font.PLAIN, 16));
		tfCPF.setColumns(10);

		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lbAgencia = new JLabel("AG:");
		lbAgencia.setFont(new Font("Arial", Font.BOLD, 16));

		tfAgencia = new JTextField();
		tfAgencia.setFont(new Font("Arial", Font.PLAIN, 16));
		tfAgencia.setColumns(10);

		JLabel lbTipoConta = new JLabel("Tipo Conta:");
		lbTipoConta.setFont(new Font("Arial", Font.BOLD, 16));

		cbbTipoConta = new JComboBox(TipoConta.values());
		cbbTipoConta.setFont(new Font("Arial", Font.PLAIN, 16));
		cbbTipoConta.setSelectedIndex(0);
		cbbTipoConta.setMaximumRowCount(3);

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

		JLabel lbUsername = new JLabel("Username:");
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
							.setCpf(tfCPF.getText()).setSenhaOperacao(tfSenhaOperacoes.getText());

					Usuario novoUsuario = new Usuario();
					novoUsuario.setLogin(tfUsername.getText())
							.setSenha(new EncodePasswordClient().encode(tfSenhaConta.getText()))
							.setTipoUsuario(TipoUsuario.CLIENTE).setPessoa(novaPessoa);
					Conta novaConta = new Conta();
					novaConta.setDataAbertura(new Date(System.currentTimeMillis()))
							.setTipoConta(TipoConta.valueOf(cbbTipoConta.getSelectedItem().toString()))
							.setAgencia(agenciaValidar).setPessoa(novaPessoa)
							.setNumero(String.valueOf(getNumeroContaDisponivel()));

					new ContaFacade(novaPessoa, novoUsuario, novaConta);

					JOptionPane.showMessageDialog(null,
							String.format("Conta %s criada com sucesso!", novaConta.getNumero()));

					limparTela();
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(TelaBackground.getPanelMenu());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbUsername)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lbNome)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lbSenhaConta)
											.addComponent(tfSenhaConta, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
										.addGap(17)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lbSenhaOperacoes, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfSenhaOperacoes, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
									.addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
									.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lbIdade, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfIdade, 197, 197, Short.MAX_VALUE)
											.addComponent(lbAgencia, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfAgencia, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
										.addGap(48)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lbTipoConta, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lbCPF, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(tfCPF, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED))
													.addComponent(cbbTipoConta, 0, 293, Short.MAX_VALUE)))))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
										.addGap(31)
										.addComponent(btnConfirme, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
								.addGap(80)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbIdade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbCPF)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbAgencia)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfAgencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbTipoConta)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbbTipoConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(28)
					.addComponent(lbUsername, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbSenhaConta)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfSenhaConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbSenhaOperacoes)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfSenhaOperacoes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConfirme, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		TelaBackground.getPanelMenu().setLayout(groupLayout);
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
		tfAgencia.setText("");
		tfCPF.setText("");
		tfIdade.setText("");
		tfNome.setText("");
		tfSenhaConta.setText("");
		tfSenhaOperacoes.setText("");
		tfUsername.setText("");
		cbbTipoConta.setSelectedIndex(0);
	}

	protected boolean validarInformacoes() {
		if (tfNome.getText().length() == 0 || tfIdade.getText().length() == 0 || tfCPF.getText().length() == 0
				|| tfAgencia.getText().length() == 0 || tfUsername.getText().length() == 0
				|| tfSenhaOperacoes.getText().length() == 0 || tfSenhaConta.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
			return false;
		}

		agenciaValidar = (Agencia) GenericDao
				.consultarByString(String.format("from Agencia where age_numAgencia like '%s'", tfAgencia.getText()));

		if (agenciaValidar == null) {
			JOptionPane.showMessageDialog(null, "Agencia nao encontrada!");
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
