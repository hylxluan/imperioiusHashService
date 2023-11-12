package com.imperioius.hash.securityhash;

import lombok.Getter;

@Getter
public class ConstOptions {
	
	private final int memoryUsage;
	private final int iterations;
	private final int threads;
	
	public ConstOptions(final int iterations, final int memoryUsage, final int threads) {
		this.iterations = iterations;
		this.memoryUsage = memoryUsage;
		this.threads = threads;
	}
}
