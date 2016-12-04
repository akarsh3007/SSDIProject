package com.cuisineratingsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories("com.cuisineratingsystem.repositories")
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages={"com.cuisineratingsystem.services","com.cuisineratingsystem.controllers","com.cuisineratingsystem.repositories","com.cuisineratingsystem.model"})
public class CuisineratingsystemApplicationTests {

	@Test
	public void contextLoads() {
		
		
	}

}
