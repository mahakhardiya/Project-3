package com.techwave.Models.Pojos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PassportLost {
	private String userId;
	@NotBlank(message = "*Required")
	private String state;
	@NotBlank(message = "*Required")
	private String city;
	@NotNull(message = "*Required")
	private Integer pincode;
	@NotBlank(message = "*Required")
	private String typeOfService;
	@NotBlank(message = "*Required")
	private String bookletType;
	
	
	
	public PassportLost() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PassportLost(String userId, @NotBlank(message = "*Required") String state,
			@NotBlank(message = "*Required") String city, @NotNull(message = "*Required") Integer pincode,
			@NotBlank(message = "*Required") String typeOfService,
			@NotBlank(message = "*Required") String bookletType) {
		super();
		this.userId = userId;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.typeOfService = typeOfService;
		this.bookletType = bookletType;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public Integer getPincode() {
		return pincode;
	}



	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}



	public String getTypeOfService() {
		return typeOfService;
	}



	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}



	public String getBookletType() {
		return bookletType;
	}



	public void setBookletType(String bookletType) {
		this.bookletType = bookletType;
	}
	
	
	
}
