package com.cuisineratingsystem.services;

import java.util.List;

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
	
	public Dish updateRatingForDish(Dish dish){
		
		return dishRepository.save(dish);
	}
	
	public List<Dish> getAllDishes(){
		
		return dishRepository.findAll();
	}
	
	public List<Dish> searchDish(String searchToken)
	{
		return dishRepository.searchDish(searchToken);
	}
}