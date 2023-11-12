package com.imperioius.hash.SecurityHash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.security.SecureRandom;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import com.imperioius.hash.provider.HashInterface;
import com.imperioius.hash.securityhash.HashResult;


public class HashTests {
	private SecureRandom securitySalt = new SecureRandom();
	private HashInterface provider = HashInterface.createServiceLoader();
	
	@Test
	public void hashWithDefaultOptionsIsTheSameAsGivenHashed() {
		final byte[] salt = new byte[0x40];
		securitySalt.nextBytes(salt);
		final HashResult hashedPass = provider.hash("userPassword3213", salt);
		
		assertEquals(10, hashedPass.getOptions().getIterations());
		assertEquals(1048576, hashedPass.getOptions().getMemoryUsage());
		assertEquals(4, hashedPass.getOptions().getThreads());
	}
	
	@Test
	public void authPassIsTheSameAsSignPass() {
		final byte[] salt = new byte[0x40];
		securitySalt.nextBytes(salt);
		final HashResult signUpPass = provider.hash("userPassword3213", salt);
		final HashResult authPass = provider.hash("userPassword3213", salt);
		assertThat(signUpPass.getHashedPass(), CoreMatchers.equalTo(authPass.getHashedPass()));
	}
	
	@Test
	public void saltGivenIsTheSameAsReturned() {
		final byte[] salt = new byte[0x40];
		securitySalt.nextBytes(salt);
		final HashResult hashedPass = provider.hash("userPassword3213", salt);
		assertThat(hashedPass.getSalt(),CoreMatchers.equalTo(salt));
	}
	
	@Test
	public void stringPassIsTheSameAsCharPass() {
		final byte[] salt = new byte[0x40];
		final HashResult stringHashedPass = provider.hash("userPassword3213".toCharArray(), salt);
		final HashResult charArrayHashedPass = provider.hash("userPassword3213", salt);
		assertThat(stringHashedPass.getHashedPass(), CoreMatchers.equalTo(charArrayHashedPass.getHashedPass()));
	}
	
}
