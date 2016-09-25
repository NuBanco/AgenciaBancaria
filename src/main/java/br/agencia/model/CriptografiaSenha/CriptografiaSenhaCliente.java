package br.agencia.model.CriptografiaSenha;

public class CriptografiaSenhaCliente extends CriotografiaSenhaAbstrata implements CriptografiaSenhaInterface {

	@Override
	public String encode(String message) {
		return hashString(message, "MD5");
	}


}
