package br.agencia.model.criptografiaSenha;

import br.agencia.model.enums.TipoUsuario;

public class CriptografiaSenhaFactory {

	public CriptografiaSenhaInterface create(final TipoUsuario tipo) {
		switch (tipo) {
		case BANCARIO:
			return new CriptografiaSenhaBancario();
		case CLIENTE:
			return new CriptografiaSenhaCliente();
		default:
			throw new RuntimeException("Tipo de criptografia nao suportado!");
		}
	}

}
