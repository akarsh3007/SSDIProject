package com.cuisineratingsystem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuisine")
public class Cuisine {
	
	@Id
	@GeneratedValue()
	@Column(name="cuisine_ID")
	private int cuisine_ID;
	
	@Column(name="cuisine_name")
	private String cuisine_name;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="no_of_raters")
	private int no_of_raters;
	
	@ManyToOne
	@JoinColumn(name="restaurant_ID")
	private Restaurant restaurant_ID;
	
	
	public int getCuisine_ID() {
		return cuisine_ID;
	}
	public void setCuisine_ID(int cuisine_ID) {
		this.cuisine_ID = cuisine_ID;
	}
	public String getCuisine_name() {
		return cuisine_name;
	}
	public void setCuisine_name(String cuisine_name) {
		this.cuisine_name = cuisine_name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getNo_of_raters() {
		return no_of_raters;
	}
	public void setNo_of_raters(int no_of_raters) {
		this.no_of_raters = no_of_raters;
	}
	public Restaurant getRestaurant_ID() {
		return restaurant_ID;
	}
	public void setRestaurant_ID(Restaurant restaurant_ID) {
		this.restaurant_ID = restaurant_ID;
	}
}
