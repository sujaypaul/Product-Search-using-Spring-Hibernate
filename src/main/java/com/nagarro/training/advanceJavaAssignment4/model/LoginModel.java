package com.nagarro.training.advanceJavaAssignment4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Users")
public class LoginModel {
	
	@Id
	@NotEmpty(message="*Username is Required")
	private String username;
	
	@NotEmpty(message="*Password is Required")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
