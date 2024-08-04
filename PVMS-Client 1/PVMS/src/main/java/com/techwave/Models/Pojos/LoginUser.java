package com.techwave.Models.Pojos;

import jakarta.validation.constraints.NotBlank;

public class LoginUser {

	@NotBlank(message = "*Required")
	private String userId;
	@NotBlank(message = "*Required")
	private String password;

	public LoginUser(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
