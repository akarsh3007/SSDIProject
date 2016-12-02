package com.cuisineratingsystem.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
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
	
	@Query("select c from Dish c where c.dish_name like %?1%")
	 List<Dish> searchDish(@Param("dish_name")String dish_name);
	
	 @Query("select d.dish_ID,d.rating,d.no_of_raters,d.dish_name, d.cuisine.restaurant.rest_name from Dish d where rating > 3 order by rating DESC, no_of_raters DESC")
	 List<Dish> getTrendingDishes(Pageable pageable);

}