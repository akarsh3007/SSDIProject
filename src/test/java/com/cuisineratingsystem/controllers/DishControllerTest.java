package com.cuisineratingsystem.controllers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.model.Dish;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplication.class)
public class DishControllerTest {

	private MockMvc mockMvc;
	private Dish dish;
	
	@Before
	public void setup() throws Exception{
		dish = new Dish();
		dish.setDish_ID(1);
		dish.setDish_name("Indian");
		dish.setNo_of_raters(1);
		dish.setRating(3);
	}
	@Test
	public void testUpdateRatingForDish() {
		try {
			this.mockMvc.perform(get("/updateDishRating",dish)).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllDishes() {
		try {
			this.mockMvc.perform(get("/getalldishes")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchCuisines() {
		try {
			this.mockMvc.perform(get("/api/dish/search","Indian")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
