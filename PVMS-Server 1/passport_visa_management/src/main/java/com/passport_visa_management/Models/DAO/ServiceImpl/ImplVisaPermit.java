package com.passport_visa_management.Models.DAO.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.passport_visa_management.Models.DAO.Services.IVisaPermit;
import com.passport_visa_management.Models.DAO.Services.VisaPermitRepository;

public class ImplVisaPermit implements IVisaPermit{

	@Autowired
	VisaPermitRepository permitRepository;
	@Override
	public int getPermitYears(String occupation) {
		// TODO Auto-generated method stub
		int expiaryYears=(int) permitRepository.findById(occupation).get().getVisaPermit();
		return expiaryYears;
	}

	
}
