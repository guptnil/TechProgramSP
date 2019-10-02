package com.filler.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestRandomValueGenerator {

	@Test
	public void testBasketNotEmpty() {
		double value = RandomValueGenerator.getValue(1, 5);
		assertTrue(value>=1 && value<=5);
		
	}
	
	
}
