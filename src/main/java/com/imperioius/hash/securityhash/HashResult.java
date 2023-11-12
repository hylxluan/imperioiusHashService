package com.imperioius.hash.securityhash;

import lombok.Getter;

@Getter
public class HashResult {
	
	private final ConstOptions options;
	private final byte[] hashedPass;
	private final byte[] salt;
	
	public HashResult(ConstOptions options, byte[] hashedPass, byte[] salt) {
		this.options = options;
		this.hashedPass = hashedPass;
		this.salt = salt;
	}
}
