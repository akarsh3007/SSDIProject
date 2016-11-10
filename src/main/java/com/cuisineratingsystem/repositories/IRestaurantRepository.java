package com.cuisineratingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cuisineratingsystem.model.*;

public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{	
	
}
