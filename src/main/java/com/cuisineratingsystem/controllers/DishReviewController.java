package com.cuisineratingsystem.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuisineratingsystem.model.DishReview;
import com.cuisineratingsystem.model.User;
import com.cuisineratingsystem.services.DishReviewService;

@RestController
public class DishReviewController {

	private DishReviewService dishReviewService;

	@Autowired
	public DishReviewController(DishReviewService dishReviewService) {
		this.dishReviewService = dishReviewService;
	}
	
	@RequestMapping(path="/addDishReview", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean AddDishReview(@RequestBody DishReview dishreview, HttpServletRequest request){
		
		return dishReviewService.AddDishReview(dishreview);
	}
	
}