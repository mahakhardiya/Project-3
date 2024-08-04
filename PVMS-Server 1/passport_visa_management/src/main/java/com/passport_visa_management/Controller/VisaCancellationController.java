package com.passport_visa_management.Controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.passport_visa_management.Models.DAO.ServiceImpl.ImplVisa;
import com.passport_visa_management.Models.DAO.Services.IVisa;
import com.passport_visa_management.Models.POJO.Cost;
import com.passport_visa_management.Models.POJO.Visa;

@CrossOrigin
@RestController
public class VisaCancellationController {
	@Autowired
	IVisa ivisa;

	@Autowired
	ImplVisa daoImpl;

	@GetMapping("/getallvisa")
	public List<Visa> getallvisa(){
		return ivisa.getAll();
	}
	
	@GetMapping("/getvisapassport/{passportId}")
	public ResponseEntity<List<Visa>> getvisa_Passport(@PathVariable String passportId ) {
		List<Visa> visadetails = ivisa.getvisa(passportId);
		return ResponseEntity.of(Optional.of(visadetails));
	}

	@GetMapping("/getvisa/{visaid}")
	public ResponseEntity<Object> getAll(@PathVariable("visaid") String visaid) {
		Visa V = null;
		try {
			V = ivisa.getById(visaid);
			return ResponseEntity.of(Optional.of(V));
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No records found");
		}
	}

	@PutMapping("/updatevisa/{id}")
	public ResponseEntity<String> modify2(@PathVariable("id") String id) {
		
		String visaid = ivisa.updateVisaStatus(id);
		if (visaid!= null) {
			return ResponseEntity.of(Optional.of("Visa Id: "+visaid+", got successfully cancelled."));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not update Visa Cancellation");
		}

	}

	@GetMapping("/getCost/{visaId}")
	public ResponseEntity<Double> getCost(@PathVariable("visaId") String visaId) {
		Cost cost = (Cost) daoImpl.findCost(visaId);
		return ResponseEntity.of(Optional.of(cost.getPrice()));
	}


	
	@GetMapping("/CountOfVisa/{userId}")
	public Boolean getVisas(@PathVariable("userId") String userId) {
		return daoImpl.getNumberOfVisas(userId, "Active");
	}
	
}
