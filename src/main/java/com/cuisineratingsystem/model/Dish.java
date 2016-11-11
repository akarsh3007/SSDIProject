package com.cuisineratingsystem.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private float rating;
	
	@Column(name="no_of_raters")
	private int no_of_raters;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name ="cuisine_ID")
	private Cuisine cuisine;
	
	@JsonManagedReference
	@OneToMany(mappedBy="dish",targetEntity=DishReview.class, cascade=CascadeType.PERSIST)
	private List<DishReview> dishReviews;
	

	public List<DishReview> getDishReviews() {
		return dishReviews;
	}

	public void setDishReviews(List<DishReview> dishReviews) {
		this.dishReviews = dishReviews;
	}

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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getNo_of_raters() {
		return no_of_raters;
	}

	public void setNo_of_raters(int no_of_raters) {
		this.no_of_raters = no_of_raters;
	}

	//@JsonBackReference("cuisine-dish")
	@JsonBackReference
	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
}
