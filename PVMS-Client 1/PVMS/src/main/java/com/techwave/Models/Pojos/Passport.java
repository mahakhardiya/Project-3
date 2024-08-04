package com.techwave.Models.Pojos;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Passport {
	
	private String passportId;
	
	private UsersRegistrations userId;

	private String country;
	@NotBlank(message = "*Required")
	private String state;
	@NotBlank(message = "*Required")
	private String city;
	@NotNull(message = "*Required")
	private Integer pincode;
	@NotNull(message = "*Required")
	private String typeOfService;
	@NotNull(message = "*Required")
	private String bookletType;
	
	private LocalDate issueDate;
	
	private LocalDate expiryDate;
	
	private String status;
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passport(String passportId, UsersRegistrations userId, String country,
			@NotBlank(message = "*Required") String state, @NotBlank(message = "*Required") String city,
			@NotNull(message = "*Required") Integer pincode, @NotNull(message = "*Required") String typeOfService,
			@NotNull(message = "*Required") String bookletType, LocalDate issueDate, LocalDate expiryDate,
			String status) {
		super();
		this.passportId = passportId;
		this.userId = userId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.typeOfService = typeOfService;
		this.bookletType = bookletType;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.status = status;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	public UsersRegistrations getUserId() {
		return userId;
	}
	public void setUserId(UsersRegistrations userId) {
		this.userId = userId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
