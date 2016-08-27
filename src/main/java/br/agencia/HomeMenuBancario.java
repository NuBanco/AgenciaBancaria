package br.agencia;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HomeMenuBancario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5853409558338193456L;

	public HomeMenuBancario() {
		setBounds(100, 100, 480, 280);
		setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().setLayout(null);
		JButton btnOpInfoConta = new JButton("1 - Informa\u00E7\u00F5es");
		btnOpInfoConta.setBackground(SystemColor.scrollbar);
		btnOpInfoConta.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpInfoConta.setBounds(35, 22, 180, 50);
		getContentPane().add(btnOpInfoConta);

		JButton btnOpNovaConta = new JButton("2 - Nova Conta");
		btnOpNovaConta.setBackground(SystemColor.scrollbar);
		btnOpNovaConta.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpNovaConta.setBounds(35, 97, 180, 50);
		getContentPane().add(btnOpNovaConta);

		JButton btnOpClientes = new JButton("3 - Clientes");
		btnOpClientes.setBackground(SystemColor.scrollbar);
		btnOpClientes.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpClientes.setBounds(35, 176, 180, 50);
		getContentPane().add(btnOpClientes);

		JButton btnOpAgencias = new JButton("6 - Ag\u00EAncias");
		btnOpAgencias.setBackground(SystemColor.scrollbar);
		btnOpAgencias.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpAgencias.setBounds(245, 22, 180, 50);
		getContentPane().add(btnOpAgencias);

		JButton btnOpBalanco = new JButton("5 - Balan\u00E7os");
		btnOpBalanco.setBackground(SystemColor.scrollbar);
		btnOpBalanco.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpBalanco.setBounds(245, 97, 180, 50);
		getContentPane().add(btnOpBalanco);

		JButton btnOpProfissionais = new JButton("4 - Profissionais");
		btnOpProfissionais.setBackground(SystemColor.scrollbar);
		btnOpProfissionais.setFont(new Font("Arial", Font.BOLD, 17));
		btnOpProfissionais.setBounds(245, 176, 180, 50);
		getContentPane().add(btnOpProfissionais);
		
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				HomeMenuBancario menuBancario = new HomeMenuBancario();
				menuBancario.setLocationRelativeTo(null);
				menuBancario.setVisible(true);
			}
		});
	}

}
