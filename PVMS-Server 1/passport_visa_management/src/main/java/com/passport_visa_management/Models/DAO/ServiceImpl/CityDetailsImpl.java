package com.passport_visa_management.Models.DAO.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passport_visa_management.Models.DAO.Services.CityRepository;
import com.passport_visa_management.Models.DAO.Services.ICityDetails;
import com.passport_visa_management.Models.DAO.Services.StateRepository;
import com.passport_visa_management.Models.POJO.CityDetails;
import com.passport_visa_management.Models.POJO.StateDetails;

@Service
public class CityDetailsImpl implements ICityDetails{

	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	StateRepository stateRepository;

	@Override
	public List<CityDetails> getAllCityDetails() {
		return cityRepository.findAll();
	}

	@Override
    public List<CityDetails> getAllCityDetailsByState(String stateName) {
        StateDetails stateDetails = stateRepository.findByStateName(stateName);
        return cityRepository.findByStateStateId(stateDetails.getStateId());
    }
	

	@Override
	public Integer getByCityName(String cityName) {
		CityDetails cityDetails=cityRepository.findByCityName(cityName);
		return cityDetails.getPincode();
	}

	@Override
	public List<String> getAllCityNames(String stateName) {
		List<CityDetails> cityDetails=getAllCityDetailsByState(stateName);
		List<String> cityNames=cityDetails.stream().map(CityDetails::getCityName).collect(Collectors.toList());
		return cityNames;
	}	
}
