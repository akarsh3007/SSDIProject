package com.cuisineratingsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="restaurant")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Restaurant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8022966604897331607L;

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
	
	@Column(name="address")
	private String address;
	
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="open_time")
	private String openTime;
	
	@Column(name="imageURL")
	private String imageURL;
		
	public int getRestaurant_ID() {
		return restaurant_ID;
	}
	
	//@JsonManagedReference("restaurant-cuisine")
	//@JsonManagedReference
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
}