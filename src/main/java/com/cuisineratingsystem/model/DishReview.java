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
@Table(name="dish_review")
public class DishReview implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 2801433808135399427L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int dish_comment_ID;

@Column(name="dish_comment_desc")
private String dishCommentDesc;

@ManyToOne
@JoinColumn(name="dish_ID")
private Dish dish;

public DishReview() {
}

public int getDish_comment_ID() {
	return this.dish_comment_ID;
}

public void setDish_comment_ID(int dish_comment_ID) {
	this.dish_comment_ID = dish_comment_ID;
}

public String getDishCommentDesc() {
	return this.dishCommentDesc;
}

public void setDishCommentDesc(String dishCommentDesc) {
	this.dishCommentDesc = dishCommentDesc;
}

@JsonBackReference
public Dish getDish() {
	return this.dish;
}

public void setDish(Dish dish) {
	this.dish = dish;
}

}