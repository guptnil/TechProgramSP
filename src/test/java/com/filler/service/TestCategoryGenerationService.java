package com.filler.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.filler.model.Category;



public class TestCategoryGenerationService {
	
	CategoryGenerationService categoryGenerationService;
	
	@Before
	public void setup() {
		categoryGenerationService = new CategoryGenerationServiceImpl();
	}
	
	
	@Test
	public void testCategoryCount() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		assertEquals(20, categoryList.size());
		
	}
	
	
	@Test
	public void testItemsCount() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		categoryList.forEach(category -> assertEquals(category.getItems().size(), 10));
		
	}
	
	
	@Test
	public void testItemsPriceUpperRange() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		categoryList.forEach(category -> category.getItems().forEach(item ->  assertTrue(item.getPrice() < 21)));
		
	}
	
	@Test
	public void testItemsCostUpperRange() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		categoryList.forEach(category -> category.getItems().forEach(item ->  assertTrue(item.getShippingCost() < 6)));
		
	}
	
	@Test
	public void testItemsRatingUpperRange() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		categoryList.forEach(category -> category.getItems().forEach(item ->  assertTrue(item.getRating() < 6)));
		
	}
	
	@Test
	public void testItemsPriceLowerRange() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		categoryList.forEach(category -> category.getItems().forEach(item ->  assertTrue(item.getPrice() >= 1)));
		
	}
	
	@Test
	public void testItemsCostLowerRange() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		categoryList.forEach(category -> category.getItems().forEach(item ->  assertTrue(item.getShippingCost() >=2)));
		
	}
	
	@Test
	public void testItemsRatingLowerRange() {
		List<Category> categoryList = categoryGenerationService.generateCategories();
		categoryList.forEach(category -> category.getItems().forEach(item ->  assertTrue(item.getRating() >=1)));
		
	}
	
	@After
	public void tearDown() {
		categoryGenerationService = null;
	}

}
