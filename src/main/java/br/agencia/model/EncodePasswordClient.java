package br.agencia.model;

public class EncodePasswordClient extends AbstractEncodePassword implements EncodePassword {

	@Override
	public String encode(String message) {
		return hashString(message, "MD5");
	}


}
