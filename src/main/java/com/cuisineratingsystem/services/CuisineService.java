package com.cuisineratingsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.Restaurant;
import com.cuisineratingsystem.repositories.ICuisineRepository;

@Service
public class CuisineService {

		private ICuisineRepository cuisineRepository;
		
		@Autowired
		public CuisineService(ICuisineRepository cuisineRepository){
			this.cuisineRepository = cuisineRepository;
		}
		
		public int updateRatingForCuisine(int id, float rating, int no_of_raters){
			return cuisineRepository.updateRating(id, rating, no_of_raters);
		}
		
		public List<Cuisine> getAllCuisines(){
			
			return cuisineRepository.findAll();
		}
		
		public Cuisine getCuisineById(int id)
		{
			return cuisineRepository.findOne(id);
		}
		
		public List<Cuisine> searchCuisines(String searchToken)
		{
			return cuisineRepository.searchCuisine(searchToken);
		}

		public List<Cuisine> getAllCuisinesByRestId(int restid) {
			return cuisineRepository.getAllCuisineByRestId(restid);
		}
		
		public List<Cuisine> getTrendingCuisines(){
			return cuisineRepository.getTrendingCuisines(new PageRequest(0,5));
		}
}
