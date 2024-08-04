package com.passport_visa_management.Models.DAO.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passport_visa_management.Models.DAO.Services.CityRepository;
import com.passport_visa_management.Models.DAO.Services.IStateDetails;
import com.passport_visa_management.Models.DAO.Services.StateRepository;
import com.passport_visa_management.Models.POJO.CityDetails;
import com.passport_visa_management.Models.POJO.StateDetails;

@Service
public class StateDetailsImpl implements IStateDetails {

	@Autowired
	StateRepository stateRepository;
	@Autowired
	CityRepository cityRepository;

	@Override
	public List<StateDetails> getAllStateDetails() {
		return stateRepository.findAll();
	}

	@Override
	public List<CityDetails> getByStateName(String stateName) {
		StateDetails stateDetail = stateRepository.findByStateName(stateName);
		return cityRepository.findByStateStateId(stateDetail.getStateId());
	}

	@Override
	public List<String> getAllStateNames() {
		List<StateDetails> stateDetails = getAllStateDetails();
		List<String> stateNames = stateDetails.stream().map(StateDetails::getStateName).collect(Collectors.toList());
		return stateNames;
	}
}
