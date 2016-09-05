package br.agencia;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.agencia.cliente.HomeMenuCliente;

public class LoginUsuario extends JFrame {

	private static final long serialVersionUID = 7781598968866921968L;
	private JTextField editUsuario;
	private JPasswordField editSenha;

	public LoginUsuario() {
		setBounds(100, 100, 300, 170);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 13));
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Login");

		editUsuario = new JTextField();
		editUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		editUsuario.setColumns(10);

		editSenha = new JPasswordField();
		editSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		editSenha.setToolTipText("");

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				TelaBackground menuBancario = new TelaBackground(new HomeMenuBancario());
				menuBancario.setSize(580, 470);
				menuBancario.setLocationRelativeTo(null);
				menuBancario.setVisible(true);
				*/
				
				TelaBackground menuCliente = new TelaBackground(new HomeMenuCliente());
				menuCliente.setSize(580, 470);
				menuCliente.setLocationRelativeTo(null);
				menuCliente.setVisible(true);
					
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
				LoginUsuario telaLogin = new LoginUsuario();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
			}
		});
	}
}
