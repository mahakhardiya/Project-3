package com.passport_visa_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passport_visa_management.Models.DAO.Services.IPassport;
import com.passport_visa_management.Models.POJO.PassportLost;

@CrossOrigin
@RestController
public class PassportLostRestController {
	
	@Autowired
	IPassport passportImpl;
	
	@PutMapping("/PassportLost")
	public ResponseEntity<String> passportLost(@RequestBody PassportLost passportLost){
		return ResponseEntity.ok(passportImpl.updatePassportAfterLoss(passportLost));
	}	
}
