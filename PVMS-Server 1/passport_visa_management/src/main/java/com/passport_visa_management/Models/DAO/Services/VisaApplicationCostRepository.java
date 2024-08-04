package com.passport_visa_management.Models.DAO.Services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passport_visa_management.Models.POJO.CompositeVisaApplicants;
import com.passport_visa_management.Models.POJO.VisaApplicationCost;

public interface VisaApplicationCostRepository extends JpaRepository<VisaApplicationCost, CompositeVisaApplicants>{
	
}
