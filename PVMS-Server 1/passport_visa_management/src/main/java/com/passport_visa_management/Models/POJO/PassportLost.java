package com.passport_visa_management.Models.POJO;



public class PassportLost {
	private String userId;
	
	private String state;
	
	private String city;
	
	private Integer pincode;
	
	private String typeOfService;
	
	private String bookletType;
	
	
	
	public PassportLost() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PassportLost(String userId,  String state,
			 String city,  Integer pincode,
			 String typeOfService,
			 String bookletType) {
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
