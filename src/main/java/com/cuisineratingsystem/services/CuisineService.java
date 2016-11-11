package com.cuisineratingsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.repositories.ICuisineRepository;

@Service
public class CuisineService {

		private ICuisineRepository cuisineRepository;
		
		@Autowired
		public CuisineService(ICuisineRepository cuisineRepository){
			this.cuisineRepository = cuisineRepository;
		}
		
		public Cuisine updateRatingForCuisine(int id, float rating, int no_of_raters){
			return cuisineRepository.updateRating(id, rating, no_of_raters);
		}
		
}
