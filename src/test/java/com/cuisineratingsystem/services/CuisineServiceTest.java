package com.cuisineratingsystem.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before; 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplication.class)
public class CuisineServiceTest {
	
	@Autowired
	CuisineService cuisineService;
	Cuisine cuisine;
		
	
	@Before
	public void setUp() throws Exception{
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurant_ID(1);
		restaurant.setRest_name("test name");
		restaurant.setLatitude(11);
		restaurant.setLongitude(11);
		restaurant.setCity("charlotte");
		restaurant.setZipcode(12345);
		
		cuisine = new Cuisine();
		cuisine.setCuisine_ID(1); 
		cuisine.setCuisine_name("test name");
		cuisine.setNo_of_raters(1);
		cuisine.setRating(3);
		cuisine.setRestaurant(restaurant);
	}
	
	@Test
	public void testUpdateRatingForCuisine() {
		cuisine = cuisineService.getCuisineById(1);
		cuisine.setRating(4);
		int raters= cuisine.getNo_of_raters();
		raters= raters + 1 ;
		int result = cuisineService.updateRatingForCuisine(cuisine.getCuisine_ID(), cuisine.getRating(), raters);
		assertNotEquals(result,0);
	}

	@Test
	public void testGetAllCuisines() {
		List<Cuisine> cuisineList = cuisineService.getAllCuisines();
		assertNotNull(cuisineList);
	}

	@Test
	public void testGetCuisineById() {
		cuisine = cuisineService.getCuisineById(1);
		assertEquals(cuisine.getCuisine_ID(),1);	
	}

	@Test
	public void testSearchCuisines() {
		List<Cuisine> list = cuisineService.searchCuisines("test");
		assertNotNull(list);
	}

	@Test
	public void testGetAllCuisinesByRestId() {
		List<Cuisine> list = cuisineService.getAllCuisinesByRestId(1);
		assertNotNull(list);
	}

}
