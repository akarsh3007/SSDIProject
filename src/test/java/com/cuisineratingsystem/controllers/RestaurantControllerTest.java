package com.cuisineratingsystem.controllers;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.CuisineratingsystemApplicationTests;
import com.cuisineratingsystem.model.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplicationTests.class)
@TestPropertySource(locations="classpath:applicationtest.properties")
public class RestaurantControllerTest {
	 
	private MockMvc mockMvc;
	@Autowired
	private RestaurantController restaurantController;
	
	@Before
    public void setUp() {

       /*this.mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();*/
       
       Restaurant restaurant = new Restaurant();
		restaurant.setRestaurant_ID(1);
		restaurant.setRest_name("test name");
		restaurant.setLatitude(11);
		restaurant.setLongitude(11);
		restaurant.setCity("charlotte");
		restaurant.setZipcode(12345);
		
    }
	
	@Test
	public void testGetAllRestaurant() {
		try {
			this.mockMvc.perform(get("/api/restaurants"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRestaurantById() {
		try {
			this.mockMvc.perform(get("/api/restaurants/1")).andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
