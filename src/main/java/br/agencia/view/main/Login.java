package br.agencia.view.main;

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
import br.agencia.model.EncodePasswordFactory;
import br.agencia.model.Usuario;
import br.agencia.model.enums.TipoUsuario;
import br.agencia.view.bancario.HomeMenuBancario;

public class Login extends JFrame {

	private static final long serialVersionUID = 7781598968866921968L;
	private JTextField editUsuario;
	private JPasswordField editSenha;

	public Login() {
		setBounds(100, 100, 300, 170);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 13));
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Login");

		HibernateUtil.getSession();

		editUsuario = new JTextField();
		editUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		editUsuario.setColumns(10);

		editSenha = new JPasswordField();
		editSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		editSenha.setToolTipText("");

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenericDao UsuarioDao = new GenericDao();
				Usuario login = new Usuario();

				if (editUsuario.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "O campo \"Usuario\" deve ser informado!");
					return;
				}

				if (editSenha.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "O campo \"Senha\" deve ser informado!");
					return;
				}

				login = (Usuario) UsuarioDao.consultarByString(new Usuario(), editUsuario.getText());

				if (login == null) {
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido(s)!");
					return;
				}

				JOptionPane.showMessageDialog(null, "XABLAU");
				//EncodePassword crip = new EncodePassword();

				System.out.println(new EncodePasswordFactory().create(TipoUsuario.CLIENTE).encode(editSenha.getText()));

//				System.out.println(this.getClass() + "Inicio");
//
//				try {
//					// Cria a instância de um classe de acesso a Dados
//					UsuarioDao dao = new UsuarioDao();
//
//					// Cria um objeto aluno informando apenas o nome
//					Usuario aluno1 = new Usuario();
//					aluno1.setLogin(editUsuario.getText());
//					aluno1.setSenha(editSenha.getText());
//
//					// Consulta a lista de usuários cadastrados no Banco
//					List<Usuario> listaUsuario = dao.listar();
//
//					// Realiza um loop para exibir todos os registro existentes
//					// no Banco de dados
//					System.out.println("==================  Listando Usuarios Cadastrados ============================");
//					for (Usuario a : listaUsuario) {
//						System.out.println(a);
//					}
//
//				} catch (Exception execp) {
//					execp.printStackTrace();
//				}
//
//				System.out.println(this.getClass() + "Fim");

				TelaBackground menuBancario = new TelaBackground(new HomeMenuBancario());
				menuBancario.setSize(580, 470);
				menuBancario.setLocationRelativeTo(null);
				menuBancario.setVisible(true);
				dispose();

				/*
				 * TelaBackground menuCliente = new TelaBackground(new
				 * HomeMenuCliente()); menuCliente.setSize(580, 470);
				 * menuCliente.setLocationRelativeTo(null);
				 * menuCliente.setVisible(true); dispose();
				 */

			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel lbUsuario = new JLabel("Usu\u00E1rio :");
		lbUsuario.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lbSenha = new JLabel("Senha :");
		lbSenha.setFont(new Font("Arial", Font.PLAIN, 17));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lbUsuario)
										.addComponent(lbSenha))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(editUsuario, GroupLayout.PREFERRED_SIZE, 157,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(editSenha, 157, 157, 157))))
				.addContainerGap(39, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(22)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbUsuario)
								.addComponent(editUsuario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbSenha)
								.addComponent(editSenha, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnLogin)
						.addContainerGap(22, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
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
