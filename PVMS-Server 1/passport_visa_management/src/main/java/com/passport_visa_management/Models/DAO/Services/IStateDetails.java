package com.passport_visa_management.Models.DAO.Services;

import java.util.List;

import com.passport_visa_management.Models.POJO.CityDetails;
import com.passport_visa_management.Models.POJO.StateDetails;

public interface IStateDetails {
	List<String> getAllStateNames();
	List<StateDetails> getAllStateDetails();
	List<CityDetails> getByStateName(String stateName);
}
