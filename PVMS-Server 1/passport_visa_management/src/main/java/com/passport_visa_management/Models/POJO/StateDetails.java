package com.passport_visa_management.Models.POJO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StateDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stateId;
	@Column(length=25)
	private String stateName;
	public StateDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StateDetails(Integer stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}	
}
