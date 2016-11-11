package com.cuisineratingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cuisineratingsystem.model.*;
import com.cuisineratingsystem.repositories.IDishRepository;

@Service
public class DishService {

	private IDishRepository dishRepository;

	@Autowired
	public DishService(IDishRepository dishRepository) {
		this.dishRepository = dishRepository;
	}
	
	public int updateRatingForDish(int id, float rating, int no_of_raters){
		
		return dishRepository.updateRating(id, rating, no_of_raters);
	}
}
