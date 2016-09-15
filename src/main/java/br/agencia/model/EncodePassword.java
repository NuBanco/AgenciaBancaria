package br.agencia.model;

import br.agencia.model.enums.TipoUsuario;

public interface EncodePassword {

	public String encode(String message);

}