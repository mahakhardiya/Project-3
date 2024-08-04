package com.passport_visa_management.Models.POJO;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity

//@NamedQuery(name="findCost",
//query = "select price from Cost where occupation=:occupation and months=:months")

public class Cost {
@Id
private Integer id;
private String occupation;
private Integer months;
private double price;
public Cost() {
	super();
	// TODO Auto-generated constructor stub
}
public Cost(Integer id, String occupation, Integer months, double price) {
	super();
	this.id = id;
	this.occupation = occupation;
	this.months = months;
	this.price = price;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getOccupation() {
	return occupation;
}
public void setOcuupation(String occupation) {
	this.occupation = occupation;
}

public Integer getMonths() {
	return months;
}
public void setMonths(Integer months) {
	this.months = months;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}



}
