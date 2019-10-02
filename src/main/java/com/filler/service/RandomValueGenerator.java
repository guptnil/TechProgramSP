package com.filler.service;

import java.util.Random;

/**
 * This class is responsible for generating the random values for a given range
 *
 */
public class RandomValueGenerator{

	public static double getValue(double min, double max) {
		Random random = new Random();
		double price = random.doubles(min,(max+1)).findFirst().getAsDouble();
		return price;
	}
	
	

}
