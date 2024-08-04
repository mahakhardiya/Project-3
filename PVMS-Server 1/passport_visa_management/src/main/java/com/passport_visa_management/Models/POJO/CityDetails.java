package com.passport_visa_management.Models.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CityDetails")
public class CityDetails {

	
	@Id
	private Integer pincode;
	@ManyToOne
	@JoinColumn(name="stateId")
	private StateDetails state;
	@Column(length = 25)
	private String cityName;
	public CityDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityDetails(Integer pincode, StateDetails state, String cityName) {
		super();
		this.pincode = pincode;
		this.state = state;
		this.cityName = cityName;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public StateDetails getState() {
		return state;
	}
	public void setState(StateDetails state) {
		this.state = state;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
