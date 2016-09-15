package br.agencia.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class AbstractEncodePassword {

	protected static String hashString(String message, String algorithm) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(message.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hashedBytes = messageDigest.digest();
		return convertBytesToHex(hashedBytes);
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
