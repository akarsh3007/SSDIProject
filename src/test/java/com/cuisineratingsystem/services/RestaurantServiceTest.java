package com.cuisineratingsystem.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.CuisineratingsystemApplicationTests;
import com.cuisineratingsystem.model.Restaurant;
import com.cuisineratingsystem.services.RestaurantService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplicationTests.class)
@TestPropertySource(locations="classpath:applicationtest.properties")
public class RestaurantServiceTest {
	 
	@Autowired
	private RestaurantService restaurantService;
	private Restaurant restaurant;
	
	@Before
	public void setUp() throws Exception{
		restaurant = new Restaurant();
		restaurant.setRestaurant_ID(1);
		restaurant.setRest_name("test name");
		restaurant.setLatitude(11);
		restaurant.setLongitude(11);
		restaurant.setCity("charlotte");
		restaurant.setZipcode(12345);
	}
	
	@Test
	public void testGetAllRestaurants() {
		List<Restaurant> restList = restaurantService.getAllRestaurant();
		assertNotNull(restList);
	}
	
	@Test
	public void testGetRestaurantById() {
		Restaurant res = restaurantService.getRestaurantById(1);
		assertNotNull(res);
	}

}
