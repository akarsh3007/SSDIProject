package com.cuisineratingsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.Dish;
import com.cuisineratingsystem.services.DishService;

@RestController
public class DishController {

	private DishService dishService;

	@Autowired
	public DishController(DishService dishService) {
		this.dishService = dishService;
	}
	
	@RequestMapping(path="/updateDishRating", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public int updateRatingForDish(@RequestBody Dish dish, HttpServletRequest request){
		
		return dishService.updateRatingForDish(dish.getDish_ID(), dish.getRating(), dish.getNo_of_raters());
	}
	
	@RequestMapping(path="/getalldishes", method=RequestMethod.GET)
	public List<Dish> getAllDishes(){
		
		return dishService.getAllDishes();
	} 
	
	@RequestMapping(path="/api/dish/search", method=RequestMethod.GET)
	public List<Dish> searchCuisines(@RequestParam("searchToken") String searchToken){
		
		return dishService.searchDish(searchToken);
	}
}