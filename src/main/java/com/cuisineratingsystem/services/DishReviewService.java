package com.cuisineratingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisineratingsystem.repositories.IDishReviewRepository;
import com.cuisineratingsystem.model.*;

@Service
public class DishReviewService {

	private IDishReviewRepository dishReviewRepository;

	@Autowired
	public DishReviewService(IDishReviewRepository dishReviewRepository) {
		this.dishReviewRepository = dishReviewRepository;
	}
	
	public boolean AddDishReview(DishReview dishreview){
		
		try
		{
			DishReview savedDishReview = dishReviewRepository.save(dishreview);
			if(savedDishReview !=null)
				return true;
		}catch(Exception e)
		{	
		}
		return false;
	}
	
}