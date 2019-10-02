package com.filler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.filler.service.BasketFillerService;
import com.filler.service.BasketFillerServiceImpl;
import com.filler.service.CategoryGenerationService;
import com.filler.service.CategoryGenerationServiceImpl;

/**
 * This is the configuration having beans.
 *
 */
@Configuration
public class MainConfig {
	
	@Bean(name = "category")
	public CategoryGenerationService getCategoryGenerationService(){
		return new CategoryGenerationServiceImpl();
	}
	
	@Bean(name = "basket")
	public BasketFillerService getBasketFillerService(){
		return new BasketFillerServiceImpl();
	}

}
