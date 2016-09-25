package br.agencia.model.criptografiaSenha;

public class CriptografiaSenhaBancario extends CriotografiaSenhaAbstrata implements CriptografiaSenhaInterface {

	@Override
	public String encode(String message) {
		return hashString(message, "SHA-256");
	}


}
