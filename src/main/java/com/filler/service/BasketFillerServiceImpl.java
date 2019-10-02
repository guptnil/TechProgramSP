package com.filler.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.filler.model.Category;
import com.filler.model.Item;
import com.filler.model.ItemComparator;

/**
 * This class is responsible for filling the basket with the items
 *
 */
public class BasketFillerServiceImpl implements BasketFillerService{

	/**
	 * It captures the first item for each category as the items are sorted based on price, shipping cost and rating and we can't pick more than
	 * one item from each category.
	 * Then it keeps filling items in the basket till the total cost reaches 50
	 */
	@Override
	public List<Item> fillBasket(List<Category> categoryList) {
		List<Item> itemsInBasket = new ArrayList<Item>();
		try {
			List<Item> categoryItems = categoryList.stream().map(x -> x.getItems().get(0)).collect(Collectors.toList());
			Collections.sort(categoryItems, new ItemComparator());
			double totalCost = 0; 
			for(Item item : categoryItems) {
				totalCost = totalCost +  item.getPrice() + item.getShippingCost();
				if(totalCost<50) {
					itemsInBasket.add(item);
				}
			}
		}catch(Exception e) {
			throw new RuntimeException("Error while filling the basket");
		}
		return itemsInBasket;
	
	}
	
	
	
	

}
