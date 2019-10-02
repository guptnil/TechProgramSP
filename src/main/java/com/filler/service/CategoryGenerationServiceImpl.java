package com.filler.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.filler.model.Category;
import com.filler.model.Item;
import com.filler.model.ItemComparator;


public class CategoryGenerationServiceImpl implements CategoryGenerationService{

	/**
	 * This method generates the item categories
	 *
	 */
	public List<Category> generateCategories() {
		List<Category> categoryList = new ArrayList<Category>();
		try {
			for(int i =1;i<=20;i++) {
				Category category = new Category("Category"+i);
				List<Item> itemsList = createItems(category);
				category.setItems(itemsList);
				categoryList.add(category);
			}
		}catch(Exception e) {
			throw new RuntimeException("Error while generating the categories");
		}
		return categoryList;
	}

	/**
	 * This method creates the items for each category, it calls RandomValueGenerator to get random values for proce, shipping cost and ratings.
	 * It then sorts the items in ascending order of total cost(price+ shipping cost) and descending order of rating 
	 *
	 */
	private List<Item> createItems(Category category) {
		List<Item> itemsList = new ArrayList<Item>();
		for(int j =1;j<=10;j++) {
			Item item = new Item(category.getCategoryName()+ ":Item" + j);
			
			double price = RandomValueGenerator.getValue(1,20);
			double shippingCost = RandomValueGenerator.getValue(2,5);
			double rating = RandomValueGenerator.getValue(1,5);
			
			item.setPrice(price);
			item.setShippingCost(shippingCost);
			item.setRating(rating);
			
			itemsList.add(item);
			
		}
		Collections.sort(itemsList, new ItemComparator());
		return itemsList;
	}

}
