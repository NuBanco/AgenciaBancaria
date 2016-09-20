package br.agencia.model;

import br.agencia.model.enums.TipoUsuario;
import br.agencia.view.bancario.HomeMenuBancario;
import br.agencia.view.cliente.HomeMenuCliente;
import br.agencia.view.principal.AbstractTelaBackground;

public class TelaFactory {

	public AbstractTelaBackground create (TipoUsuario tipo) {
		switch (tipo) {
		case BANCARIO:
			return new HomeMenuBancario();
		case CLIENTE:
			return new HomeMenuCliente();
		default:
			throw new RuntimeException("Tipo de criptografia nao suportado!");
		}
	}
}
