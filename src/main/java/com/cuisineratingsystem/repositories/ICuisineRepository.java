package com.cuisineratingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuisineratingsystem.model.Cuisine;

@Repository
public interface ICuisineRepository extends JpaRepository<Cuisine, Integer>{

	 @Modifying
	 @Query("UPDATE Cuisine c SET c.rating=:rating, c.no_of_raters=:no_of_raters WHERE c.id=:id")
	 Cuisine updateRating(@Param("id") int id, @Param("rating") float rating, @Param("no_of_raters") int no_of_raters);
}
