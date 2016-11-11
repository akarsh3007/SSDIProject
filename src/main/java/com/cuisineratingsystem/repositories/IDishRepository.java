package com.cuisineratingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cuisineratingsystem.model.Cuisine;
import com.cuisineratingsystem.model.Dish;

@Repository
public interface IDishRepository extends JpaRepository<Dish, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE Dish d SET d.rating=:rating, d.no_of_raters=:no_of_raters WHERE d.dish_ID=:id")
	 int updateRating(@Param("id") int id, @Param("rating") float rating, @Param("no_of_raters") int no_of_raters);

}