package com.cuisineratingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	
	public int updateRatingForDish(Dish dish){
		
		return dishRepository.updateRating(dish.getDish_ID(), dish.getRating(), dish.getNo_of_raters());
	}
	
	public List<Dish> getAllDishes(){
		
		return dishRepository.findAll();
	}
	
	public List<Dish> searchDish(String searchToken)
	{
		return dishRepository.searchDish(searchToken);
	}
	
	public List<Dish> getTrendingDishes(){
		return dishRepository.getTrendingDishes(new PageRequest(0,5));
	}
}