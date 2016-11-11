package com.cuisineratingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cuisineratingsystem.model.CuisineReview;
import com.cuisineratingsystem.model.DishReview;
import com.cuisineratingsystem.model.*;

@Repository
public interface IDishReviewRepository extends JpaRepository<DishReview,Integer> {

}