package com.passport_visa_management.Models.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompositeVisaApplicants {
	@Column(length = 25)
	private String occupation;
	@Column(length = 25)
	private String place;
	public CompositeVisaApplicants() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompositeVisaApplicants(String occupation, String place) {
		super();
		this.occupation = occupation;
		this.place = place;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
}
