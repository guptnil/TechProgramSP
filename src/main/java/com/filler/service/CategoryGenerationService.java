package com.filler.service;

import java.util.List;

import com.filler.model.Category;

/**
 * Interface responsible for generating the item categories
 *
 */
public interface CategoryGenerationService {
	
	List<Category> generateCategories();

}
