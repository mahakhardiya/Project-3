package com.passport_visa_management.Models.DAO.Services;

import java.util.List;

import com.passport_visa_management.Models.POJO.VisaApplicationCost;

public interface IVisaCost {
	public Integer findCost(String occupationId,String place);
	public List<VisaApplicationCost> getAllPrices();
	public List<VisaApplicationCost> getAllPlaces();
}
