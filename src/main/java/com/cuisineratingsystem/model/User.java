package com.cuisineratingsystem.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable {


	private static final long serialVersionUID = -4290568060876398390L;
	
	@Id
	@GeneratedValue()
	@Column(name="id")
	private int id;
	
	@Column(name="contact")
	private String contactNo;
	
	@Column(name= "firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String passWord;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getPassword() {
		return passWord;
	}

	public void setPassword(String password) {
		this.passWord = password;
	}
	
	
}
