package com.cuisineratingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cuisineratingsystem.model.Cuisine;

@Repository
public interface ICuisineRepository extends JpaRepository<Cuisine, Integer>{

	 @Modifying
	 @Transactional
	 @Query("UPDATE Cuisine c SET c.rating=:rating, c.no_of_raters=:no_of_raters WHERE c.cuisine_ID=:cuisine_ID")
	 int updateRating(@Param("cuisine_ID") int cuisine_ID, @Param("rating") float rating, @Param("no_of_raters") int no_of_raters);
}
