package com.passport_visa_management.Controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passport_visa_management.Models.DAO.Services.IUsersRegistrations;
import com.passport_visa_management.Models.POJO.UpdatePwdUsers;
import com.passport_visa_management.Models.POJO.UsersRegistrations;


@CrossOrigin
@RestController
public class UserRegistrationController {

	IUsersRegistrations usersRegistraionServiceImpl;

	public UserRegistrationController(IUsersRegistrations usersRegistraionServiceImpl) {
		super();
		this.usersRegistraionServiceImpl = usersRegistraionServiceImpl;
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UsersRegistrations>> getAllUsers() {
		List<UsersRegistrations> ulist = usersRegistraionServiceImpl.getAllUsers();
		return ResponseEntity.of(Optional.of(ulist));
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<Object> getUserdetailsById(@PathVariable("id") String id) {
		try {
			UsersRegistrations u = usersRegistraionServiceImpl.getUserById(id);
			return ResponseEntity.of(Optional.of(u));

		} catch (NoSuchElementException E) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No record found with id: " + id);

		}

	}

	@PostMapping("/addUserDetails")
	public ResponseEntity<String> addUserDetails(@RequestBody UsersRegistrations inputDetails) {
		UsersRegistrations existingEmail = usersRegistraionServiceImpl.getByEmail(inputDetails.getEmail());
		UsersRegistrations existingContact = usersRegistraionServiceImpl
				.getByContactNumber(inputDetails.getContactNumber());

		if (existingEmail != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
		}
		if (existingContact != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Contact number already exists");
		}

		String responseMessage = usersRegistraionServiceImpl.addUserDetails(inputDetails);
		return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
	}

	@PutMapping("/updateUserPwd/{id}")
	public ResponseEntity<String> updatePwd(@RequestBody UpdatePwdUsers u, @PathVariable("id") String id) {
		UsersRegistrations ur = usersRegistraionServiceImpl.updatePassword(id, u);
		if (ur == null)
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("No record found for id: " + id);

		else
			return ResponseEntity.of(Optional.of("Your password has been updated successfully!"));
	}

}
