package com.techwave.Models.Pojos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;

public class VisaCancellation {
	@NotBlank(message="*Required")
	private String visaId;
	private String passportId;
	private String userId;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate issueDate;
	private String country;
	public VisaCancellation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisaCancellation(@NotBlank(message = "*Required") String visaId,
			@NotBlank(message = "*Required") String passportId, String userId, LocalDate issueDate, String country) {
		super();
		this.visaId = visaId;
		this.passportId = passportId;
		this.userId = userId;
		this.issueDate = issueDate;
		this.country = country;
	}
	public String getVisaId() {
		return visaId;
	}
	public void setVisaId(String visaId) {
		this.visaId = visaId;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
