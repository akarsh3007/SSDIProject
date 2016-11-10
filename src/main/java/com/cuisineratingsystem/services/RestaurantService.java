package com.cuisineratingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisineratingsystem.repositories.IRestaurantRepository;
import com.cuisineratingsystem.model.*;

@Service
public class RestaurantService {
	
	private IRestaurantRepository restaurantRepository;

	@Autowired
	public RestaurantService(IRestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	public List<Restaurant> getAllRestaurant(){
		
		return restaurantRepository.findAll();
	}

	public Restaurant getRestaurantById(int id){
		
		return restaurantRepository.findOne(id);
	}
}
