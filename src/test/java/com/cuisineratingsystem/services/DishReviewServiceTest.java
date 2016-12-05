package com.cuisineratingsystem.services;

import static org.junit.Assert.*;

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
import com.cuisineratingsystem.model.DishReview; 
import com.cuisineratingsystem.model.Restaurant;
 
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplicationTests.class)
@TestPropertySource(locations="classpath:applicationtest.properties")
public class DishReviewServiceTest {
	
	@Autowired
	DishReviewService dishReviewService;
	DishReview dishReview;
	
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
		
		Dish dish = new Dish();
		dish.setDish_ID(1);
		dish.setDish_name("test dish name");
		dish.setNo_of_raters(1);
		dish.setRating(3);
		dish.setCuisine(cuisine);
		
		dishReview = new DishReview();
		dishReview.setDish(dish);
		dishReview.setDish_comment_ID(1);
		dishReview.setDishCommentDesc("Test comment");
		
	}

	@Test
	public void testAddDishReview() {
		boolean result = dishReviewService.AddDishReview(dishReview);
		assert(result);
	}

}
