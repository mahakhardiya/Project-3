package com.passport_visa_management.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.passport_visa_management.Models.DAO.Services.IPassport;
import com.passport_visa_management.Models.POJO.RenewalOfPassport;

@CrossOrigin
@RestController
public class RenewalRestController {
	
	
	@Autowired
	IPassport iPassport;
	
	@PutMapping("/ReissuePassport")
	public ResponseEntity<Object> reissuePassport(@RequestBody RenewalOfPassport passportRenewal){
		try {
			String userDetails=iPassport.SaveRenewalDetailsToDb(passportRenewal);
			return ResponseEntity.ok(Optional.of(userDetails));
		}
		catch (Exception e) {
			return ResponseEntity.ok("Error Renewal of Passport");
		}
	}
}
