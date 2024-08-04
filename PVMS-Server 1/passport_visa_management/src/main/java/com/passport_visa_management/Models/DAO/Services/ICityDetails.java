package com.passport_visa_management.Models.DAO.Services;

import java.util.List;

import com.passport_visa_management.Models.POJO.CityDetails;

public interface ICityDetails{
	 List<String> getAllCityNames(String stateName);
	 List<CityDetails> getAllCityDetails();
	 List<CityDetails> getAllCityDetailsByState(String stateName);
	 Integer getByCityName(String cityName);
 }
