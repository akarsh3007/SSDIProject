package com.cuisineratingsystem.controllers;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuisineratingsystem.Constants;
import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.CuisineReview;
import com.cuisineratingsystem.services.CuisineReviewService;

@RestController
public class CuisineReviewController {
	private CuisineReviewService cuisineReviewService;
	
	@Autowired
	public CuisineReviewController(CuisineReviewService cuisineReviewService){
		this.cuisineReviewService = cuisineReviewService;
	}
	
	@RequestMapping(path=Constants.APIPath.CuisineReview.AddCuisineReview, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean addReview(@RequestBody CuisineReview cuisineReview, HttpServletRequest request)
	{
		
		return cuisineReviewService.addReview(cuisineReview);
		
	}
	
	@RequestMapping(path=Constants.APIPath.CuisineReview.GetCuisineReviewById, method=RequestMethod.GET)
	public CuisineReview addReview(@PathVariable("id") int id)
	{
		
		return cuisineReviewService.getCuisineReviewById(id);
		
	}
	
}
