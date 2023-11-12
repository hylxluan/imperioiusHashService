package com.imperioius.hash.securityhash;

import java.security.SecureRandom;

import com.imperioius.hash.provider.HashInterface;

public class Client {
	
	private static SecureRandom securitySalt = new SecureRandom();
	private static HashInterface provider = HashInterface.createServiceLoader();
	
	public static void main(String[] args) {
		
		final byte[] salt = new byte[0x10];
		securitySalt.nextBytes(salt);
		final HashResult hashedPass = provider.hash("cuzinhogrosso333", salt);
		System.out.println(hashedPass.getHashedPass());
		System.out.println(hashedPass.getHashedPass());
		System.out.println(hashedPass.getOptions());
		System.out.println(hashedPass.getOptions());
		System.out.println(hashedPass.getOptions().getIterations());
	}

}
