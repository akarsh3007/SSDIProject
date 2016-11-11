package com.cuisineratingsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="cuisine_review")
public class CuisineReview implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1229369888662520404L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int cuisine_comment_ID;

@Column(name="cuisine_comment_desc")
private String cuisineCommentDesc;

@ManyToOne
@JoinColumn(name="cuisine_ID",referencedColumnName="cuisine_ID")
private Cuisine cuisine;

public CuisineReview() {
}

public int getCuisine_comment_ID() {
	return this.cuisine_comment_ID;
}

public void setCuisine_comment_ID(int cuisine_comment_ID) {
	this.cuisine_comment_ID = cuisine_comment_ID;
}

public String getCuisineCommentDesc() {
	return this.cuisineCommentDesc;
}

public void setCuisineCommentDesc(String cuisineCommentDesc) {
	this.cuisineCommentDesc = cuisineCommentDesc;
}

@JsonBackReference
public Cuisine getCuisine() {
	return this.cuisine;
}

public void setCuisine(Cuisine cuisine) {
	this.cuisine = cuisine;
}

	
}
