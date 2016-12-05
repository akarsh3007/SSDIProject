package com.cuisineratingsystem.model;

import static org.junit.Assert.*;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import com.cuisineratingsystem.CuisineratingsystemApplicationTests;
import com.cuisineratingsystem.services.CuisineReviewService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplicationTests.class)
@TestPropertySource(locations="classpath:applicationtest.properties")
public class CuisineReviewTest {
	
	@Autowired
	private CuisineReviewService cuisineReviewService;
	private CuisineReview cuisineReview;
	
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
		
		cuisineReview = new CuisineReview();
		cuisineReview.setCuisine(cuisine);
		cuisineReview.setCuisine_comment_ID(0);
		cuisineReview.setCuisineCommentDesc("Test comment");
		
	}

	
	@Test
	public void testCuisineIDPositive() {
		boolean result = cuisineReviewService.addReview(cuisineReview);
		assertNotNull(result);
		
	}
	
	/*@Test
	public void testCuisineIDNegative() {
		boolean result =cuisineReviewService.addReview(cuisineReview);
		assertNull(result);
	}*/
}
