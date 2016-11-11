package com.cuisineratingsystem.controllers;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.User;
import com.cuisineratingsystem.services.CuisineService;

@RestController
public class CuisineController {

	private CuisineService cuisineService;
	
	@Autowired
	public CuisineController(CuisineService cuisineService){
		this.cuisineService = cuisineService;
	}
	
	@RequestMapping(path="/updateCuisineRating", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Cuisine UpdateCusuineRating(@RequestBody Cuisine cuisine, HttpServletRequest request)
	{
		
		return cuisineService.updateRatingForCuisine(cuisine.getCuisine_ID(), cuisine.getRating(), cuisine.getNo_of_raters());
		
	}
}
