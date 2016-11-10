package com.cuisineratingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cuisineratingsystem.model.Cuisine;

@Repository
public interface ICuisineRepository extends JpaRepository<Cuisine, Integer>{

}
