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
import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.Dish;
import com.cuisineratingsystem.model.Restaurant;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplicationTests.class)
@TestPropertySource(locations="classpath:applicationtest.properties")
public class DishServiceTest {
	
	@Autowired
	private DishService dishService;
	private Dish dish;
		
	@Before
	public void setUp() throws Exception{
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurant_ID(1);
		restaurant.setRest_name("test name");
		restaurant.setLatitude(11);
		restaurant.setLongitude(11);
		restaurant.setCity("charlotte");
		restaurant.setZipcode(12345);
		
		Cuisine cuisine = new Cuisine();
		cuisine.setCuisine_ID(1); 
		cuisine.setCuisine_name("test cuisine name");
		cuisine.setNo_of_raters(1);
		cuisine.setRating(3);
		cuisine.setRestaurant(restaurant);
		
		dish = new Dish();
		dish.setDish_ID(1);
		dish.setDish_name("test dish name");
		dish.setNo_of_raters(1);
		dish.setRating(3);
		dish.setCuisine(cuisine);
	}


	@Test
	public void testUpdateRatingForDish() {
		dish.setRating(5);
		int num = dish.getNo_of_raters();
		num = num + 1;
		int result = dishService.updateRatingForDish(dish);
		assertNotEquals(result,0);
	}

	/*@Test
	public void testGetAllDishes() {
		List<Dish> dishList = dishService.getAllDishes();
		assertNotEquals(dishList,null);
	}*/

}
