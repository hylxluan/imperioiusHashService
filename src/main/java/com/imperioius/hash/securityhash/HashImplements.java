package com.imperioius.hash.securityhash;


import com.imperioius.hash.provider.HashInterface;

import de.mkammerer.argon2.Argon2Advanced;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;


public class HashImplements implements HashInterface {
	
	private static final ConstOptions OPTIONS = new ConstOptions(10, 1048576, 4);
	
	@Override
	public HashResult hash(char[] userPassword, byte[] salt) {
		Argon2Advanced algoryth = Argon2Factory.createAdvanced(Argon2Types.ARGON2id);
		byte[] hashedPass = algoryth.rawHash(OPTIONS.getIterations(), OPTIONS.getMemoryUsage(), OPTIONS.getThreads(), 
				                                                                                      userPassword, 
				                                                                                             salt);
		return new HashResult(OPTIONS, hashedPass, salt);
	}

	@Override
	public HashResult hash(String userPassword, byte[] salt) {
		Argon2Advanced algoryth = Argon2Factory.createAdvanced(Argon2Types.ARGON2id);
		byte[] hashedPass = algoryth.rawHash(OPTIONS.getIterations(), OPTIONS.getMemoryUsage(), OPTIONS.getThreads(), 
				                                                                          userPassword.toCharArray(), 
				                                                                                               salt);
		return new HashResult(OPTIONS, hashedPass, salt);
	}

}
