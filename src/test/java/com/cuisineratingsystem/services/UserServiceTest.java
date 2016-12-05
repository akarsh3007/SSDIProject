package com.cuisineratingsystem.services;
 
import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cuisineratingsystem.CuisineratingsystemApplication;
import com.cuisineratingsystem.CuisineratingsystemApplicationTests;
import com.cuisineratingsystem.model.User;
import com.cuisineratingsystem.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CuisineratingsystemApplicationTests.class)
@TestPropertySource(locations="classpath:applicationtest.properties")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	@Test
	public final void testGetAllUsers() {
			
		List<User> actual = (List<User>) userService.getAllUsers();
		/*ArrayList<User> expected = new ArrayList<User>();
		
		User user1 = new User();
		user1.setId(1);
		user1.setEmail("gupta.akarsh@gmail.com");
		user1.setFirstName("Akarsh");
		user1.setPassword("akarsh11");
		user1.setLastName("Gupta");
		user1.setContactNo("8147768150");
		
		User user2 = new User();
		user2.setId(2);
		user2.setEmail("zack.keplinger@gmail.com");
		user2.setFirstName("Zack");
		user2.setPassword("zkep8");
		user2.setLastName("Keplinger");
		user2.setContactNo("9182938492");
		
		expected.add(user1);
		expected.add(user2);*/
		boolean testResult = false;
		if(actual != null && actual.size() > 0)
			testResult = true;
		assertTrue(testResult);
	}

	@Test
	public final void testFindByUserById() {
		/*User user2 = new User();
		user2.setId(2);
		user2.setEmail("zack.keplinger@gmail.com");
		user2.setPassword("zkep8");
		user2.setFirstName("Zack");
		user2.setLastName("Keplinger");
		user2.setContactNo("9182938492");*/
		boolean testResult = false;
		User userResult = userService.findByUserById(2);
		if(userResult.getId() == 2)
			testResult = true;
		assertTrue(testResult);
	}

	@Test
	public final void testFindUserByEmail() {
		
		User user2 = new User();
		user2.setId(2);
		user2.setEmail("zack.keplinger@gmail.com");
		user2.setFirstName("Zack");
		user2.setPassword("zkep8");
		user2.setLastName("Keplinger");
		user2.setContactNo("9182938492");
		userService.createUser(user2);
		boolean testResult = false;
		User user3 = userService.findUserByEmail("zack.keplinger@gmail.com");
		if(user3.getEmail().equalsIgnoreCase("zack.keplinger@gmail.com"))
			testResult = true;
		assertTrue(testResult);
		
	}

	@Test
	public final void testAuthenticateUser() {
		
		User user2 = new User();
		user2.setId(2);
		user2.setEmail("zack.keplinger@gmail.com");
		user2.setFirstName("Zack");
		user2.setPassword("zkep8");
		user2.setLastName("Keplinger");
		user2.setContactNo("9182938492");
		userService.createUser(user2);
		boolean testResult = false;
		User user3 = userService.authenticateUser("zack.keplinger@gmail.com", "zkep8");
		if(user3.getEmail().equalsIgnoreCase("zack.keplinger@gmail.com") && user3.getPassword().equalsIgnoreCase("zkep8"))
			testResult = true;
		assertTrue(testResult);
		
	}

	@Test
	public final void testCreateUser() throws Exception{
		User user4 = new User();
		user4.setEmail("zk1.kep@gmail.com");
		user4.setFirstName("Ze");
		user4.setPassword("zk8");
		user4.setLastName("Kep");
		user4.setContactNo("018338492");
		User userObj = userService.findUserByEmail("zk1.kep@gmail.com");
		if(userObj == null)
		assertTrue(userService.createUser(user4));
		else
			assertFalse(userService.createUser(user4));
		
	}

}
