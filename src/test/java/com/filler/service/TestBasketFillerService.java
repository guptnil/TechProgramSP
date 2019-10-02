package com.filler.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.filler.model.Category;
import com.filler.model.Item;

public class TestBasketFillerService {
	
	BasketFillerService basketFillerService;
	
	List<Category> categoryList ;
	
	@Before
	public void setup() {
		basketFillerService = new BasketFillerServiceImpl();
		CategoryGenerationServiceImpl categoryGenerationService = new CategoryGenerationServiceImpl();
		categoryList = categoryGenerationService.generateCategories();
		
	}
	
	
	@Test
	public void testBasketNotEmpty() {
		List<Item> itemList = basketFillerService.fillBasket(categoryList);
		assertNotNull(itemList);
		
	}
	
	@Test
	public void testItemsCountNotExceedCategoryCount() {
		List<Item> itemList = basketFillerService.fillBasket(categoryList);
		assertTrue(itemList.size() <=20);
	}
	
	@Test
	public void testTotalCostForItems() {
		List<Item> itemsinBasket = basketFillerService.fillBasket(categoryList);
		double totalCost = 0;
		
		for(Item item : itemsinBasket) {
			totalCost = totalCost + item.getPrice() + item.getShippingCost();
		}
		assertTrue(totalCost<=50);
	}
	
	@After
	public void tearDown() {
		basketFillerService = null;
		categoryList = null;
	}

}
