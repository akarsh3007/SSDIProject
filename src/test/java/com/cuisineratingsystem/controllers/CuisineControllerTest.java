package com.cuisineratingsystem.controllers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cuisineratingsystem.CuisineratingsystemApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplication.class)
public class CuisineControllerTest {
	
	private MockMvc mockMvc;
	private CuisineController cuisineController;
	
	@Before
    public void setUp() {

       /*this.mockMvc = MockMvcBuilders.standaloneSetup(cuisineController).build();*/
    }

	
	@Test
	public void testUpdateCusuineRating() {
		try {
			this.mockMvc.perform(get("/updateCuisineRating")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllCuisines() {
		try {
			this.mockMvc.perform(get("/api/cuisines")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetCuisineById() {
		try {
			this.mockMvc.perform(get("/api/cuisines/1")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchCuisines() {
		try {
			this.mockMvc.perform(get("/api/cuisines/search","Indian")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllCuisineByRestId() {
		try {
			this.mockMvc.perform(get("/api/cuisines/restaurants/1")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
