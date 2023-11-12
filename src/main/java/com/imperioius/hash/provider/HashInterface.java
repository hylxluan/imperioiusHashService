package com.imperioius.hash.provider;

import java.util.ServiceLoader;

import com.imperioius.hash.securityhash.HashResult;

public interface HashInterface {
	
	HashResult hash(char[] userPassword, byte[] salt);
	HashResult hash(String userPassword, byte[] salt);
	
	static HashInterface createServiceLoader() {
		return ServiceLoader.load(HashInterface.class).findFirst().get();
	}
	
}
