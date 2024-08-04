package com.techwave.Models.Pojos;

public class VisaPermit {

	private String occupation;
	private int visaPermit;
	public VisaPermit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisaPermit(String occupation, int visaPermit) {
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
	public int getVisaPermit() {
		return visaPermit;
	}
	public void setVisaPermit(int visaPermit) {
		this.visaPermit = visaPermit;
	}
	
	
}
