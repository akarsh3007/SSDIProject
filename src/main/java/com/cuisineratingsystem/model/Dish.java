package com.cuisineratingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dish")
public class Dish {
	
	@Id
	@GeneratedValue()
	@Column(name="dish_ID")
	private int dish_ID;
	
	@Column(name="dish_name")
	private String dish_name;
	
	@Column(name="dish_description")
	private String dish_description;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="no_of_raters")
	private int no_of_raters;
	
	@ManyToOne
	@JoinColumn(name ="cuisine_ID")
	private Cuisine cuisine_ID;

	public int getDish_ID() {
		return dish_ID;
	}

	public void setDish_ID(int dish_ID) {
		this.dish_ID = dish_ID;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public String getDish_description() {
		return dish_description;
	}

	public void setDish_description(String dish_description) {
		this.dish_description = dish_description;
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

	public Cuisine getCuisine_ID() {
		return cuisine_ID;
	}

	public void setCuisine_ID(Cuisine cuisine_ID) {
		this.cuisine_ID = cuisine_ID;
	}
}
