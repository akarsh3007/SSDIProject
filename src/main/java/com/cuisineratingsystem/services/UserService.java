package com.cuisineratingsystem.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cuisineratingsystem.model.User;
import com.cuisineratingsystem.repositories.IUserRepository;

@Service
public class UserService {

	
	private IUserRepository userRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User findByUserById(Integer id)
	{
		return userRepository.findOne(id);
	}
	
	public User findUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	
}
