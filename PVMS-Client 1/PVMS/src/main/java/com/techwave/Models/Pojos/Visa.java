package com.techwave.Models.Pojos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class Visa {
	private String visaId;
	private Passport passportId;
	private String userId;
	@NotBlank(message = "*Required")
	private String country;
	@NotBlank(message = "*Required")
	private String occupation;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateOfApplication;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate issueDate;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate expiryDate;
	private int registrationCost;	
	private String status;
	public Visa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Visa(String visaId, Passport passportId, String userId, @NotEmpty(message = "*Required") String country,
			@NotBlank(message = "*Required") String occupation, LocalDate dateOfApplication, LocalDate issueDate,
			LocalDate expiryDate, int registrationCost, String status) {
		super();
		this.visaId = visaId;
		this.passportId = passportId;
		this.userId = userId;
		this.country = country;
		this.occupation = occupation;
		this.dateOfApplication = dateOfApplication;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.registrationCost = registrationCost;
		this.status = status;
	}
	public String getVisaId() {
		return visaId;
	}
	public void setVisaId(String visaId) {
		this.visaId = visaId;
	}
	public Passport getPassportId() {
		return passportId;
	}
	public void setPassportId(Passport passportId) {
		this.passportId = passportId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public LocalDate getDateOfApplication() {
		return dateOfApplication;
	}
	public void setDateOfApplication(LocalDate dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
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
	public int getRegistrationCost() {
		return registrationCost;
	}
	public void setRegistrationCost(int registrationCost) {
		this.registrationCost = registrationCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
