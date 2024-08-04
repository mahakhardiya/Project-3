package com.passport_visa_management.Models.POJO;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;


@Entity

@NamedQueries({
		@NamedQuery(
				name = "VisaApplicationCost.findApplicationCost",
				query = "SELECT v.price FROM VisaApplicationCost v WHERE v.occupationId.occupation = :occupation AND v.occupationId.place = :place"
				),
		
})

public class VisaApplicationCost {
	@EmbeddedId
	private CompositeVisaApplicants occupationId;
	private int price;
	public VisaApplicationCost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisaApplicationCost(CompositeVisaApplicants occupationId, int price) {
		super();
		this.occupationId = occupationId;
		this.price = price;
	}
	public CompositeVisaApplicants getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(CompositeVisaApplicants occupationId) {
		this.occupationId = occupationId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
