package com.passport_visa_management.Models.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class VisaPermit {
	@Id
	@Column(length = 25)
	private String occupation;
	private double visaPermit;
	public VisaPermit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisaPermit(String occupation, double visaPermit) {
		super();
		this.occupation = occupation;
		this.visaPermit = visaPermit;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public double getVisaPermit() {
		return visaPermit;
	}
	public void setVisaPermit(double visaPermit) {
		this.visaPermit = visaPermit;
	}
	
	
}
