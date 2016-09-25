package br.agencia.model.util;

import br.agencia.model.entidadesPersistidas.Usuario;
import br.agencia.view.principal.Login;

public class UsuarioLogado extends Usuario{
	private static Usuario usuarioLogado;

	public static Usuario getUsuarioLogado() {
		if (usuarioLogado == null){
			new Login();
		}
		return usuarioLogado;
	}

	public static Usuario setNewUser(Usuario usuarioLogin) {
		if (getUsuarioLogado() == null){
			usuarioLogado = usuarioLogin;
		}
		return getUsuarioLogado();
	}
}
