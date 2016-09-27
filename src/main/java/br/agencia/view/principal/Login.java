package br.agencia.view.principal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.control.GenericDao;
import br.agencia.control.HibernateUtil;
import br.agencia.model.criptografiaSenha.CriptografiaSenhaFactory;
import br.agencia.model.entidadesPersistidas.Pessoa;
import br.agencia.model.entidadesPersistidas.Usuario;
import br.agencia.model.enums.SituacaoConta;
import br.agencia.model.enums.TipoUsuario;
import br.agencia.model.util.TelaFactory;
import br.agencia.model.util.UsuarioLogado;

public class Login extends JFrame {

	private static final long serialVersionUID = 7781598968866921968L;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;

	public Login() {
		setBounds(100, 100, 350, 250);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 13));
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Login");

		HibernateUtil.getSession();
		validarAdmin();

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		tfUsuario.setColumns(10);

		tfSenha = new JPasswordField();
		tfSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		tfSenha.setToolTipText("");

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuarioLogin = new Usuario();
				String senhaLogin = "";

				tfUsuario.setText(tfUsuario.getText().trim());

				if (tfUsuario.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "O campo \"Usuario\" deve ser informado!");
					return;
				}

				if (tfSenha.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "O campo \"Senha\" deve ser informado!");
					return;
				}

				usuarioLogin = (Usuario) GenericDao
						.consultarByQuery(String.format("from Usuario where usu_login like '%s'", tfUsuario.getText()));

				if (usuarioLogin == null) {
					JOptionPane.showMessageDialog(null, "Usuario nao cadastrado!");
					return;
				}

				senhaLogin = new CriptografiaSenhaFactory().create(usuarioLogin.getTipoUsuario())
						.encode(tfSenha.getText());

				if (!senhaLogin.equals(usuarioLogin.getSenha())) {
					JOptionPane.showMessageDialog(null, "Senha invalida!");
					return;
				}
				

				UsuarioLogado.setNewUser(usuarioLogin);

				if (UsuarioLogado.getContaUsuarioLogado().getSituacaoConta() == SituacaoConta.INATIVA){
					JOptionPane.showMessageDialog(null, "Esta conta esta desativada.", "Alerta", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				new TelaFactory().create(usuarioLogin.getTipoUsuario());
				TelaBackground.getTelaPrincipal().setSize(700, 660);
				TelaBackground.getTelaPrincipal().setLocationRelativeTo(null);
				TelaBackground.getTelaPrincipal().setVisible(true);

				dispose();
			}
		});

		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));

		JLabel lbUsuario = new JLabel("Usu\u00E1rio :");
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel lbSenha = new JLabel("Senha :");
		lbSenha.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lbSenha)
								.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lbUsuario).addGap(229))
								.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(tfUsuario, Alignment.LEADING)
										.addComponent(tfSenha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 288,
												Short.MAX_VALUE)
										.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 91,
												GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)))
				.addGap(1)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(22).addComponent(lbUsuario)
										.addGap(18)
										.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGap(14).addComponent(lbSenha).addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(tfSenha, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnLogin).addContainerGap(121, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
	}

	private void validarAdmin() {
		Usuario usuarioAdmin = (Usuario) GenericDao.consultarByQuery("from Usuario where usu_login like 'admin'");
		if (usuarioAdmin == null) {
			usuarioAdmin = new Usuario();
			Pessoa pessoaAdmin = new Pessoa();
			pessoaAdmin.setCpf("00000000000").setIdade(99).setNome("ADMIN").setSenhaOperacao("123456");
			usuarioAdmin.setLogin("admin").setSenha("8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")
					.setTipoUsuario(TipoUsuario.BANCARIO).setPessoa(pessoaAdmin);
			GenericDao.getGenericDao().incluir(pessoaAdmin);
			GenericDao.getGenericDao().incluir(usuarioAdmin);
		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Login telaLogin = new Login();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
			}
		});
	}
}
