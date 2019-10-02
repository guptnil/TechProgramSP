package com.filler.model;

import java.util.Comparator;

/**
 * This class is responsible for sorting the items in ascending order of price and cost but descending order of rating
 * so that maximum items can be identified/picked for filling the basket while ensuring the total rating is optimized
 *
 */
public class ItemComparator implements Comparator<Item>{

	public int compare(Item o1, Item o2) {
		int result1 = sortAscending(o1.getPrice()+o1.getShippingCost(),o2.getPrice()+o2.getShippingCost());
		if(result1==0) {
			int result2 = sortDescending(o1.getRating(),o2.getRating());
			return result2;
			
		}
		return result1;
	}
	
	private int sortAscending(double val1, double val2) {
		if(val1==val2) 
			return 0;  
		else if(val1>val2)  
			return 1;  
		else  
			return -1; 
		
	}
	
	private int sortDescending(double val1, double val2) {
		if(val1==val2) 
			return 0;  
		else if(val1>val2)  
			return -1;  
		else  
			return 1; 
		
	}

}
