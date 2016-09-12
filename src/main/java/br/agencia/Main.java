package br.agencia;

import java.awt.EventQueue;

import br.agencia.view.main.LoginUsuario;

public class Main {

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
