package com.passport_visa_management.Models.DAO.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.passport_visa_management.Models.DAO.Services.IVisaCost;
import com.passport_visa_management.Models.DAO.Services.VisaApplicationCostRepository;
import com.passport_visa_management.Models.POJO.VisaApplicationCost;



public class ImplVisaCost implements IVisaCost{

	@Autowired
	VisaApplicationCostRepository visacostrepo;
	
	@Override
	public Integer findCost(String occupation, String place) {
		// TODO Auto-generated method stub		
		return null;
	}

	@Override
	public List<VisaApplicationCost> getAllPrices() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<VisaApplicationCost> getAllPlaces() {
		// TODO Auto-generated method stub
		List<VisaApplicationCost> li=visacostrepo.findAll();
		
		return li;
	}

}

