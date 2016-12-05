package com.cuisineratingsystem.controllers;

 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.CuisineratingsystemApplicationTests;

  
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplicationTests.class)
@TestPropertySource(locations="classpath:applicationtest.properties")
public class AccountControllerTest {

	private MockMvc mockMvc;	 
	@Test
	public final void testGetAllUsers() {
		try {
			this.mockMvc.perform(get("/users"))
			.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public final void testGetUser() {
		try {
			this.mockMvc.perform(get("/users/test@test.com"))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public final void testLogout() {
		try {
			this.mockMvc.perform(get("/logout"))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
