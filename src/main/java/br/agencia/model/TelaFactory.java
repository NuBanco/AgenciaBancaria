package br.agencia.model;

import br.agencia.model.enums.TipoUsuario;
import br.agencia.view.bancario.HomeMenuBancario;
import br.agencia.view.cliente.HomeMenuCliente;
import br.agencia.view.principal.TelaBackground;

public class TelaFactory {

	public void create (TipoUsuario tipo) {
		switch (tipo) {
		case BANCARIO:
			TelaBackground.clearPanelMenu();
			TelaBackground.getPanelMenu().add(new HomeMenuBancario());
			return;
		case CLIENTE:
			TelaBackground.clearPanelMenu();
			TelaBackground.getPanelMenu().add(new HomeMenuCliente());
			return;
		default:
			throw new RuntimeException("Tipo de usuario nao existe!");
		}
	}
}
