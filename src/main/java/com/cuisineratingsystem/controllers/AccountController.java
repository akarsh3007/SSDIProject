package com.cuisineratingsystem.controllers;



import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuisineratingsystem.Constants;
import com.cuisineratingsystem.model.User;
import com.cuisineratingsystem.services.UserService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(path="/users/{email}", method=RequestMethod.GET)
	public User GetUser(@PathVariable("email") String email)
	{
		email = email.replace("-", ".");
		return userService.findUserByEmail(email);
	}
	
	@RequestMapping(path = "/signIn", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean Authenticate(@RequestBody User user,HttpSession userSession,HttpServletRequest request)
	{
		User loggedInUser = userService.authenticateUser(user.getEmail(), user.getPassword());
		
		if(loggedInUser!=null)
		{
			userSession = request.getSession();
			userSession.setAttribute(Constants.SessionVariables.email, loggedInUser.getEmail());
			userSession.setAttribute(Constants.SessionVariables.firstName, loggedInUser.getFirstName());
			userSession.setAttribute(Constants.SessionVariables.lastName, loggedInUser.getLastName());
			userSession.setAttribute(Constants.SessionVariables.contactNo, loggedInUser.getContactNo());
			return true;
			
		}
		else
		{
			return false;
		}		
		
	}
	
	@RequestMapping(path="/signUp", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean SignUp(@RequestBody User user, HttpServletRequest request)
	{
		
		return userService.createUser(user);
		
	}
	
	 @RequestMapping(path="/logout",method = RequestMethod.GET)
	    public void logout(HttpSession userSession, HttpServletRequest request) 
	 {

	        if(userSession != null){
	            userSession.invalidate();
	        }
	 }
	 
	 @RequestMapping(path="/currentuser", method=RequestMethod.GET)
	 public User getLoggedInUser(HttpSession userSession, HttpServletRequest request )
	 {
		userSession = request.getSession();
		if(userSession !=null)
		{
			User currentUser = new User();
			currentUser.setEmail(userSession.getAttribute(Constants.SessionVariables.email).toString());
			currentUser.setFirstName(userSession.getAttribute(Constants.SessionVariables.firstName).toString());
			currentUser.setLastName(userSession.getAttribute(Constants.SessionVariables.lastName).toString());
			currentUser.setContactNo(userSession.getAttribute(Constants.SessionVariables.contactNo).toString());
			
			return currentUser;
		}
		
		return null;
	 }
	 

}
