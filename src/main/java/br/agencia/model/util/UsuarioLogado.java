package br.agencia.model.util;

import br.agencia.control.GenericDao;
import br.agencia.model.entidadesPersistidas.Conta;
import br.agencia.model.entidadesPersistidas.Usuario;
import br.agencia.view.principal.Login;

public class UsuarioLogado extends Usuario {
	private static Usuario usuarioLogado;

	public static Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			new Login();
		}
		return usuarioLogado;
	}

	public static Conta getContaUsuarioLogado() {
		return (Conta) GenericDao.getGenericDao().consultarByQuery(
				String.format("from Conta where con_idPessoa = %d", getUsuarioLogado().getPessoa().getId()));
	}

	public static Usuario setNewUser(Usuario usuarioLogin) {
		if (getUsuarioLogado() == null) {
			usuarioLogado = usuarioLogin;
		}
		return getUsuarioLogado();
	}
}
