package com.cuisineratingsystem.controllers;


import java.util.*;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuisineratingsystem.model.User;
import com.cuisineratingsystem.services.UserService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class AccountController {

	
	private UserService userService;
	@Autowired
	public AccountController(UserService userService) {
		this.userService = userService;
	
	}
	
	@RequestMapping(path="/users", method=RequestMethod.GET)
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}
	
	@RequestMapping(path="/users/{userName}", method=RequestMethod.GET)
	public User GetUser(@PathVariable("userName") String userName)
	{
		return userService.findUserByUserName(userName);
	}
	
	

}
