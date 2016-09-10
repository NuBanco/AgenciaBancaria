package br.agencia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import br.agencia.enums.TipoUsuario;

public class EncodeSenha {

	public String criptografar(final String valor, final TipoUsuario tipo){
		String senha = "";

		if (tipo.ordinal() == 0){
			senha = genMD5(valor);
		} else {
			senha = genSHA256(valor);
		}

		return senha;
	}

	private static String hashString(String message, String algorithm) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hashedBytes = messageDigest.digest();
		return convertBytesToHex(hashedBytes);
	}

	public static String genMD5(String message) { // generate MD5
		return hashString(message, "MD5");
	}

	public static String genSHA256(String message) { // generate SHA-256
		return hashString(message, "SHA-256");
	}

	private static String convertBytesToHex(byte[] bytes) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xff & bytes[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}

}