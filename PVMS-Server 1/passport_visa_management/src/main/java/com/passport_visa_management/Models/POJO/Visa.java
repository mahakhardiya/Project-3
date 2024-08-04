 package com.passport_visa_management.Models.POJO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Visa {
	@Id
	@Column(length = 25)
	private String visaId;
	@ManyToOne
	@JoinColumn(name = "passportId")
	private Passport passportId;
	@Column(length = 25)
	private String userId;
	@Column(length = 25)
	private String country;
	@Column(length=25)
	private String occupation;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateOfApplication;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate issueDate;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate expiryDate;
	@Column(length = 10)
	private int registrationCost;
	@Column(length = 25)
	private String status;
	public Visa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Visa(String visaId, Passport passportId, String userId, String country, String occupation,
			LocalDate dateOfApplication, LocalDate issueDate, LocalDate expiryDate, int registrationCost,
			String status) {
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
