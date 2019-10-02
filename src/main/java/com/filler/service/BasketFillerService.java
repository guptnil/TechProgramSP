package com.filler.service;

import java.util.List;

import com.filler.model.Category;
import com.filler.model.Item;

/**
 * Interface responsible for filling the basket
 *
 */
public interface BasketFillerService {
	
	public List<Item> fillBasket(List<Category> categoryList);
}
