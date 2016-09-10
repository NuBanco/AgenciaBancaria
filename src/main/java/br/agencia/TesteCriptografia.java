package br.agencia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class TesteCriptografia {

	private TesteCriptografia() { // default constructor
	}

	public static void main(String[] args) { // main
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe uma senha  : ");
		String stringForHashCalculation = scan.nextLine();
		scan.close();
		System.out.println("Sua Senha -> " + stringForHashCalculation);
		System.out.println("MD5   : " + genMD5(stringForHashCalculation));
		System.out.println("SHA256: " + genSHA256(stringForHashCalculation));
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

	// convert bytes to hex
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