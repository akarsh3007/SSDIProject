package com.cuisineratingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static com.stormpath.spring.config.StormpathWebSecurityConfigurer.stormpath;


@EnableJpaRepositories("com.cuisineratingsystem.repositories")
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages={"com.cuisineratingsystem.services","com.cuisineratingsystem.controllers","com.cuisineratingsystem.repositories","com.cuisineratingsystem.model"})
public class CuisineratingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuisineratingsystemApplication.class, args);
		
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		 http.apply(stormpath()).and().authorizeRequests()
		 .antMatchers("/","/html/**","/css/**","/js/**","/fonts/**","/login/**","/register/**","/home/**","/search/**","/maps/**",
			"/profile/**","/verify-email/**","/forgot-password/**","/change-password/**","/restaurant/**","/trending/**",
			"/app.js","/app.css","/navbar/**","/spinner/**").permitAll()
		 .and().authorizeRequests().antMatchers("/api/**").fullyAuthenticated();
		  
	  }
	}
	
}
