package com.cuisineratingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisineratingsystem.model.CuisineReview;
import com.cuisineratingsystem.repositories.ICuisineReviewRepository;

@Service
public class CuisineReviewService {
	private ICuisineReviewRepository cuisineReviewRepository;
	
	@Autowired
	public CuisineReviewService(ICuisineReviewRepository cuisineReviewRepository){
		this.cuisineReviewRepository = cuisineReviewRepository;
	}
	
	public boolean addReview(CuisineReview cuisineReview)
	{
		CuisineReview savedCuisineReview = cuisineReviewRepository.save(cuisineReview);
		if(savedCuisineReview !=null)
				return true;
		return false;
	}
}
