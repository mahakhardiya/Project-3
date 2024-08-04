package com.passport_visa_management.Models.DAO.ServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.passport_visa_management.Models.DAO.Services.IUsersRegistrations;
import com.passport_visa_management.Models.DAO.Services.UsersRepository;
import com.passport_visa_management.Models.POJO.UpdatePwdUsers;
import com.passport_visa_management.Models.POJO.UsersRegistrations;

@Service
public class UserRegistrationImpl implements IUsersRegistrations{

	@Autowired
	UsersRepository usersRepository;
	

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<UsersRegistrations> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public String addUserDetails(UsersRegistrations URdetails) {
		
		Long count = usersRepository.count();
		String generatedUserId = "PASS-" + String.format("%04d", count + 1);
		URdetails.setUserId(generatedUserId);

		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM"));
		String[] splitted = formattedDate.split("-");
		char[] specialCharacters = { '#', '@', '$' };
		Random rand = new Random();
		int indexOfSpecial = rand.nextInt(specialCharacters.length);
		Set<Integer> uniqueNumbers = new HashSet<>();
		while (uniqueNumbers.size() < 1) {
			int randomNumber = rand.nextInt(900) + 100;
			uniqueNumbers.add(randomNumber);
		}
		String generatedPassword = splitted[0] + splitted[1] + specialCharacters[indexOfSpecial]
				+ uniqueNumbers.iterator().next();
		

		String encryptedGeneratedPassword = passwordEncoder.encode(generatedPassword);

		URdetails.setPassword(encryptedGeneratedPassword);

		int age = Period.between(URdetails.getDateOfBirth(), LocalDate.now()).getYears();
		String citizenType;

		if (age < 1) {
			citizenType = "infant";
		} else if (age < 10) {
			citizenType = "Children";
		} else if (age < 20) {
			citizenType = "Teen";
		} else if (age < 50) {
			citizenType = "Adult";
		} else {
			citizenType = "Senior Citizen";
		}

		URdetails.setCitizenType(citizenType);
		URdetails.setStatus("N");

		UsersRegistrations u = usersRepository.save(URdetails);
		
		return "Dear user,<br> Your user id: " + u.getUserId() + "<br> Password: " + generatedPassword + "<br> Citizen Type: " + u.getCitizenType();

	}

	@Override
	public UsersRegistrations getByEmail(String email) {
		// TODO Auto-generated method stub
		return usersRepository.findByEmailIs(email);
	}

	@Override
	public UsersRegistrations getByContactNumber(String number) {
		// TODO Auto-generated method stub
		return usersRepository.findByContactNumberIs(number);
	}

	@Override
	public UsersRegistrations updatePassword(String id, UpdatePwdUsers u) {
	    UsersRegistrations urOld = null;
	    urOld = usersRepository.findById(id).get();
	    if (urOld != null) {
	        String newPwd = passwordEncoder.encode(u.getNewPassword());
	        urOld.setPassword(newPwd);
	        urOld.setStatus("Y");
	        usersRepository.save(urOld);
	    }
	    return urOld;
	}
	
	@Override
	public UsersRegistrations getUserById(String userId) {
		return usersRepository.findById(userId).get();
	}

	

}
