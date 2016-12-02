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
import com.cuisineratingsystem.model.User;

@Repository
public interface ICuisineRepository extends JpaRepository<Cuisine, Integer>{

	 @Modifying
	 @Transactional
	 @Query("UPDATE Cuisine c SET c.rating=:rating, c.no_of_raters=:no_of_raters WHERE c.cuisine_ID=:cuisine_ID")
	 int updateRating(@Param("cuisine_ID") int cuisine_ID, @Param("rating") float rating, @Param("no_of_raters") int no_of_raters);
	 
	 @Query("select c from Cuisine c where c.cuisine_name like %?1%")
	 List<Cuisine> searchCuisine(@Param("cuisine_name")String cuisine_name);
	 
	 @Query("select c from Cuisine c where c.restaurant.restaurant_ID =:restid")
	 List<Cuisine> getAllCuisineByRestId(@Param("restid")int restid);
	 
	 @Query("select c.cuisine_name, c.cuisine_ID, c.rating, c.no_of_raters, c.restaurant.rest_name, c.imageURL from Cuisine c where rating > 3 order by rating DESC, no_of_raters DESC")
	 List<Cuisine> getTrendingCuisines(Pageable pageable);
	 
}
