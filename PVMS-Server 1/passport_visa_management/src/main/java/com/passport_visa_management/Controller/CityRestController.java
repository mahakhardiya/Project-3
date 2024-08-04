package com.passport_visa_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.passport_visa_management.Models.DAO.Services.ICityDetails;
import com.passport_visa_management.Models.POJO.CityDetails;

@CrossOrigin
@RestController
public class CityRestController {
	
	@Autowired
	ICityDetails iCityDetails;
	
	
	@RequestMapping("/getAllCityDetails")
	public List<CityDetails> getAllCityDetails(){
		return iCityDetails.getAllCityDetails();
	}
}
