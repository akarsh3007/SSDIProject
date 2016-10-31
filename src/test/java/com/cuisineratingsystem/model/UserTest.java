package com.cuisineratingsystem.model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.model.User;
import com.cuisineratingsystem.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplication.class)
public class UserTest {

	@Autowired
	private UserService userService;
	private User user;
	
	@Before
	public void setUp() throws Exception{
		user = new User();
		user.setFirstName("First name");
		user.setLastName("Last name");
		user.setEmail("test@email.com");
		user.setContactNo("0000111101");
		user.setPassword("password");
	}
 
	@Test
	public void testFirstNamePositive(){
		User userObj = userService.findUserByEmail("test@email.com");
		if(userObj == null)
		assertTrue(userService.createUser(user));
		else
			assertFalse(userService.createUser(user));
		
	}
	
	@Test
	public void testFirstNameNegative(){
		user.setFirstName(null);
		assertFalse(userService.createUser(user));
	}
	
	@Test
	public void testLastNamePositive(){
		User userObj = userService.findUserByEmail("test@email.com");
		if(userObj == null)
			assertTrue(userService.createUser(user));
			else
				assertFalse(userService.createUser(user));
	}
	
	@Test
	public void testLastNameNegative(){
		user.setLastName(null);
		assertFalse(userService.createUser(user));
	}
	
	@Test
	public void testEmailPositive(){
		User userObj = userService.findUserByEmail("test@email.com");
		if(userObj == null)
			assertTrue(userService.createUser(user));
			else
				assertFalse(userService.createUser(user));
	}
	
	@Test
	public void testEmailNegative(){
		user.setEmail(null);
		assertFalse(userService.createUser(user));
	}
	
	@Test
	public void testPasswordPositive(){
		User userObj = userService.findUserByEmail("test@email.com");
		if(userObj == null)
			assertTrue(userService.createUser(user));
			else
				assertFalse(userService.createUser(user));
	}
	
	@Test
	public void testPasswordNegative(){
		user.setPassword(null);
		assertFalse(userService.createUser(user));
	}

}
