package com.passport_visa_management.Models.POJO;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Passport implements Serializable{
	@Id
	@Column(length = 25)
	private String passportId;
	@ManyToOne
	@JoinColumn(name="userId")
	private UsersRegistrations userId;
	@Column(length = 25)
	private String country;
	@Column(length = 25)
	private String state;
	@Column(length = 25)
	private String city;
	@Column(length = 6)
	private Integer pincode;
	@Column(length = 25)
	private String typeOfService;
	@Column(length = 25)
	private String bookletType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate issueDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	private String status;
	
	public Passport() {
		super();
	}
	
	public Passport(String passportId, UsersRegistrations userId, String country, String state, String city,
			Integer pincode, String typeOfService, String bookletType, LocalDate issueDate, LocalDate expiryDate,
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
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



	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", userId=" + userId + ", country=" + country + ", state=" + state
				+ ", city=" + city + ", pincode=" + pincode + ", typeOfService=" + typeOfService + ", bookletType="
				+ bookletType + ", issueDate=" + issueDate + ", expiryDate=" + expiryDate + "]";
	}

	
	
}
