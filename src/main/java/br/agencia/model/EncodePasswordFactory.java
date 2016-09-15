package br.agencia.model;

import br.agencia.model.enums.TipoUsuario;

public class EncodePasswordFactory {

	public EncodePassword create(final TipoUsuario tipo) {
		switch (tipo) {
		case BANCARIO:
			return new EncodePasswordBanking();
		case CLIENTE:
			return new EncodePasswordClient();
		default:
			throw new RuntimeException("Tipo de criptografia nao suportado!");
		}
	}

}
