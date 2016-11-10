package com.cuisineratingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisineratingsystem.model.CuisineReview;

@Repository
public interface ICuisineReviewRepository extends JpaRepository<CuisineReview,Integer> {

}
