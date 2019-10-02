package com.filler;

import java.text.DecimalFormat;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.filler.model.Category;
import com.filler.model.Item;
import com.filler.service.BasketFillerService;
import com.filler.service.CategoryGenerationService;

/**
 * This is the starting point of the application, It loads the application context to inject the isntances of services required for filling the basket.
 * 
 *
 */
public class MainRunner {
	
	static Logger logger = Logger.getLogger(MainRunner.class.getName());
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		CategoryGenerationService categoryGenerationService = context.getBean("category", CategoryGenerationService.class);
		BasketFillerService basketFillerService = context.getBean("basket", BasketFillerService.class);
		
		List<Category> categoryList = categoryGenerationService.generateCategories();
		List<Item> itemsinBasket = basketFillerService.fillBasket(categoryList);
		printItems(itemsinBasket);
		
	}
	
	
	/**
	 * This method is responsible for printing the coordinates of the selected items e.g their name, total cost, sum of ratings. 
	 */
	private static void printItems(List<Item> itemsinBasket) {
		double totalCost = 0;
		double totalRating = 0;
		StringJoiner itemNameJoiner = new StringJoiner(",");
		for(Item item : itemsinBasket) {
			itemNameJoiner.add(item.getItemName());
			totalCost = totalCost + item.getPrice() + item.getShippingCost();
			totalRating = totalRating + item.getRating();
		}
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Items picked -> " + itemNameJoiner.toString());
		System.out.println("Total Cost = " + df.format(totalCost) + "$");
		System.out.println("Sum of Ratings = " + df.format(totalRating));
		
	}


	

}
