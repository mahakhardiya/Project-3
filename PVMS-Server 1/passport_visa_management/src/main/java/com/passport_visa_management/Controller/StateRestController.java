package com.passport_visa_management.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.passport_visa_management.Models.DAO.Services.ICityDetails;
import com.passport_visa_management.Models.DAO.Services.IStateDetails;
import com.passport_visa_management.Models.POJO.CityDetails;
import com.passport_visa_management.Models.POJO.StateDetails;

@CrossOrigin
@RestController
public class StateRestController {
	
	@Autowired
	IStateDetails iStateDetails;
	
	@Autowired
	ICityDetails iCityDetails;
	
	//Imp
	@GetMapping("/getAllStateDetails")
	public ResponseEntity<List<StateDetails>> getAllStateDetails(){
		List<StateDetails> AllStateDetails=iStateDetails.getAllStateDetails();
		return ResponseEntity.of(Optional.of(AllStateDetails));
	}
	//Imp
	@GetMapping("/getAllStateNames")
	public ResponseEntity<List<String>> getAllStateNames(){
		List<String> AllStateNames=iStateDetails.getAllStateNames();
		return ResponseEntity.of(Optional.of(AllStateNames));
	}
	//Imp
	@GetMapping("/getAllCityDetails/{stateName}")
    public ResponseEntity<List<CityDetails>> getAllCityDetailsByState(@PathVariable String stateName) {
        List<CityDetails> cityDetailsByState = iCityDetails.getAllCityDetailsByState(stateName);
        return ResponseEntity.ok(cityDetailsByState);
    }	
	
	@GetMapping("/getAllCityNames/{stateName}")
	public ResponseEntity<List<String>> getAllCityNamesByState(@PathVariable String stateName) {
	    List<String> cityNames = iCityDetails.getAllCityNames(stateName);
	    return ResponseEntity.ok(cityNames);
	}
	@GetMapping("/getPinCode/{cityName}")
	public ResponseEntity<Integer> getAllPinCodesByCityName(@PathVariable String cityName) {
	    Integer pincode = iCityDetails.getByCityName(cityName);
	    return ResponseEntity.ok(pincode);
	}	
}
