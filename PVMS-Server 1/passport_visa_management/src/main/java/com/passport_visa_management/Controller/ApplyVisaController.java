package com.passport_visa_management.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.passport_visa_management.Models.DAO.ServiceImpl.ImplVisa;
import com.passport_visa_management.Models.DAO.ServiceImpl.ImplVisaCost;
import com.passport_visa_management.Models.DAO.ServiceImpl.ImplVisaPermit;
import com.passport_visa_management.Models.DAO.Services.IPassport;
import com.passport_visa_management.Models.POJO.Passport;
import com.passport_visa_management.Models.POJO.UsersRegistrations;
import com.passport_visa_management.Models.POJO.Visa;
import com.passport_visa_management.Models.POJO.VisaApplicationCost;

@CrossOrigin
@RestController
public class ApplyVisaController {

	@Autowired
	ImplVisa implvisa;
	
	@Autowired
	ImplVisaCost implvisacost;
	
	@Autowired
	ImplVisaPermit implVisaPermit;
	
	@Autowired
	ImplVisaCost implcost;
	
	@Autowired
	IPassport passportImpl;
	
	@PostMapping("/addVisa")
	public ResponseEntity<?> insertVisa(@RequestBody Visa v)
	{
		Visa visa=implvisa.insertVisa(v);
		return ResponseEntity.of(Optional.of(visa));
	}
	
	@GetMapping("/getVisa")
	public ResponseEntity<?> find()
	{
		List<Visa> list=implvisa.fetchVisa();
		return ResponseEntity.of(Optional.of(list));
	}
	@GetMapping("/getVisaPermit/{occupation}")
	public ResponseEntity<?> getVisaPermit(@PathVariable("occupation") String occupation)
	{
		int expiryYears=implVisaPermit.getPermitYears(occupation);
		return ResponseEntity.of(Optional.of(expiryYears));
	}
	
	
	@GetMapping("/getAllPlaces")
	public ResponseEntity<?> getVisaPlaces()
	{
	    List<VisaApplicationCost> li = implcost.getAllPlaces();
	    return ResponseEntity.of(Optional.of(li));
	}
	
	@GetMapping("/getVisaCountrys/{userId}")
	public ResponseEntity<List<String>> getVisaCountrys(@PathVariable("userId") String userId)
	{
		List<Visa> list=implvisa.getByUserIdAndStatus(userId,"Active");
		List<String> countryList=new ArrayList<String>();
		for (Visa visa : list) {
			countryList.add(visa.getCountry());
		}
		return ResponseEntity.of(Optional.of(countryList));
	}
	
	@GetMapping("/getVisa/{userId}")
	  public ResponseEntity<?> find(@PathVariable("userId") String userId)
		{
			List<Visa> list=implvisa.fetchVisa(userId);
			return ResponseEntity.of(Optional.of(list));
		}
	
}
