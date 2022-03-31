package com.rest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfo {
	@Id@GeneratedValue
	@Column(name = "userId" ,length=20)
	private int userId;
	@Column(name = "email", length=50)
	private String email;
	@Column(name ="firstName", length=20)
	private String firstName;
	@Column(name = "lastName", length=20)
	private String lastName;
	@Column(name = "setPassword", length=20)
	private String setPassword;
	@Column(name = "confirmPassword", length=20)
	private String confirmPassword;
	
	
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	public UserInfo(int userId, String email, String firstName, String lastName, String setPassword,
			String confirmPassword) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.setPassword = setPassword;
		this.confirmPassword = confirmPassword;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
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




	public String getSetPassword() {
		return setPassword;
	}




	public void setSetPassword(String setPassword) {
		this.setPassword = setPassword;
	}




	public String getConfirmPassword() {
		return confirmPassword;
	}




	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}




	}
