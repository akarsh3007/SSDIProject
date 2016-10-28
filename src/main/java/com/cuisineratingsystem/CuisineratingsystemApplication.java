package com.cuisineratingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableJpaRepositories("com.cuisineratingsystem.repositories")
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages={"com.cuisineratingsystem.services","com.cuisineratingsystem.controllers","com.cuisineratingsystem.repositories","com.cuisineratingsystem.model"})
public class CuisineratingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuisineratingsystemApplication.class, args);
	}
	
	
	
}
