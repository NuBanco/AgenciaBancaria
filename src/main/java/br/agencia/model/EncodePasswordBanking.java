package br.agencia.model;


public class EncodePasswordBanking extends AbstractEncodePassword implements EncodePassword {

	@Override
	public String encode(String message) {
		return hashString(message, "SHA-256");
	}


}
