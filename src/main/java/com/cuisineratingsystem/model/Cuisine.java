package com.cuisineratingsystem.model;

import java.io.Serializable;
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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="cuisine")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Cuisine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5694960411769253025L;

	@Id
	@GeneratedValue()
	@Column(name="cuisine_ID")
	private int cuisine_ID;
	
	@Column(name="cuisine_name")
	private String cuisine_name;
	
	@Column(name="rating")
	private float rating;
	
	@Column(name="no_of_raters")
	private int no_of_raters;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="restaurant_ID")
	private Restaurant restaurant;
	
	//@JsonManagedReference
	@OneToMany(mappedBy="cuisine",targetEntity=Dish.class, cascade=CascadeType.PERSIST)
	private List<Dish> dish;
	
	//@JsonManagedReference
	@OneToMany(mappedBy="cuisine",targetEntity=CuisineReview.class, cascade=CascadeType.PERSIST)
	private List<CuisineReview> cuisineReviews;

	public List<CuisineReview> getCuisineReviews() {
		return cuisineReviews;
	}
	public void setCuisineReviews(List<CuisineReview> cuisineReviews) {
		this.cuisineReviews = cuisineReviews;
	}

	public List<Dish> getDish() {
		return dish;
	}
	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}

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
	
	//@JsonBackReference("restaurant-cuisine")
	//@JsonBackReference
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
