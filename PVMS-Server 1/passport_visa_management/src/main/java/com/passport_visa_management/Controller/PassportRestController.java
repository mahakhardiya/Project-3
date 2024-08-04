package com.passport_visa_management.Controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.passport_visa_management.Models.DAO.Services.IPassport;
import com.passport_visa_management.Models.DAO.Services.IUsersRegistrations;
import com.passport_visa_management.Models.POJO.Passport;
import com.passport_visa_management.Models.POJO.UsersRegistrations;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class PassportRestController {
	
	@Autowired
	IPassport passportImpl;
	
	@Autowired
	IUsersRegistrations usersRegistraionServiceImpl;

	@GetMapping("/getAllPassportDetails")
	public ResponseEntity<List<Passport>> getAll(){
		List<Passport> passportList=passportImpl.getAll();
		return ResponseEntity.of(Optional.of(passportList));		
	}
	
	@GetMapping("/getByPassportId/{passportId}")
	public ResponseEntity<Object> getById(@PathVariable("passportId") String passportId,Model model){
		
		try {		
		Passport userPassport=passportImpl.getByPassportId(passportId);
		return ResponseEntity.of(Optional.of(userPassport));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Record Found");
		}	
	}
	
	
	@GetMapping("/getPassport/{userId}")
	public ResponseEntity<Object> getByUserId(@PathVariable("userId") String userId){
		
		try {		
		Passport userPassport=passportImpl.getByUserId(userId);
		return ResponseEntity.of(Optional.of(userPassport));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Record Found");
		}	
	}
	
	
	
	@GetMapping("/checkExpiry/{userId}")
	public ResponseEntity<String> checkExpiryDate(@PathVariable("userId") String userId){
		
		try {		
			String message=passportImpl.checkExpiryDate(userId);
			return ResponseEntity.of(Optional.of(message));
		}
		catch (Exception e) {
			return ResponseEntity.of(Optional.of("It looks like you dont have a existing passport!<br>Please apply Passport "));
		}	
	}
	
	

	@GetMapping("/fetchabyuserid/{userId}")
	public Passport fetchByUserId(@PathVariable String userId) {
		return passportImpl.getByUserId(userId);
	}

	@PostMapping("/passportdatainsert/{userId}")
	public ResponseEntity<Object> passportdatainsert(@PathVariable String userId,
			@RequestBody Passport user) {
		String data_user = passportImpl.createpassport(user, userId);
		return ResponseEntity.of(Optional.of(data_user));

	}

	@GetMapping("/PassportExists/{userId}")
	public ResponseEntity<Object> passportExists(@PathVariable String userId) {
		String message= passportImpl.PassportExists(userId);
			return ResponseEntity.of(Optional.of(message));
	}
	
}