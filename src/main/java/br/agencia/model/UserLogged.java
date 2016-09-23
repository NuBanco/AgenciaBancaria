package br.agencia.model;

import br.agencia.view.principal.Login;

public class UserLogged extends Usuario{
	private static UserLogged usuarioLogado;

	public static UserLogged getUsuarioLogado() {
		if (usuarioLogado == null){
			new Login();
		}
		return usuarioLogado;
	}

	public static Usuario setNewUser(Usuario usuarioLogin) {
		if (getUsuarioLogado() == null){
			usuarioLogado = (UserLogged) usuarioLogin;
		}
		return getUsuarioLogado();
	}
}
