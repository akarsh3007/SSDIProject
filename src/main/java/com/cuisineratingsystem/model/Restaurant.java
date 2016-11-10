package com.cuisineratingsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

@Entity
@Table(name="restaurant")
public class Restaurant {

	@Id
	@GeneratedValue()
	@Column(name="restaurant_ID")
	private int restaurant_ID;
	
	@Column(name="rest_name")
	private String rest_name;
	
	@Column(name="latitude")
	private float latitude;
	
	@Column(name="longitude")
	private float longitude;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zipcode")
	private int zipcode;
	
	public int getRestaurant_ID() {
		return restaurant_ID;
	}
	
	//@JsonManagedReference("restaurant-cuisine")
	@JsonManagedReference
	@OneToMany(mappedBy="restaurant",targetEntity=Cuisine.class, cascade=CascadeType.PERSIST)
	private List<Cuisine> cuisines;
	
	
	public List<Cuisine> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<Cuisine> cuisine) {
		this.cuisines = cuisine;
	}

	public void setRestaurant_ID(int restaurant_ID) {
		this.restaurant_ID = restaurant_ID;
	}
	
	public String getRest_name() {
		return rest_name;
	}
	
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	
	public float getLatitude() {
		return latitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}
	
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
