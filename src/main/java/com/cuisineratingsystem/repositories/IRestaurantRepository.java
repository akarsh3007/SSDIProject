package com.cuisineratingsystem.repositories;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cuisineratingsystem.model.*;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{	
	
	@Query("select r from Restaurant r where r.rest_name like %?1%")
	 List<Restaurant> searchRestaurant(String rest_name);
}
