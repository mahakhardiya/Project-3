package com.passport_visa_management.Models.DAO.ServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.passport_visa_management.Models.DAO.Services.IPassport;

import com.passport_visa_management.Models.DAO.Services.PassportRepository;
import com.passport_visa_management.Models.DAO.Services.UsersRepository;
import com.passport_visa_management.Models.DAO.Services.VisaRepository;
import com.passport_visa_management.Models.POJO.Passport;
import com.passport_visa_management.Models.POJO.PassportLost;
import com.passport_visa_management.Models.POJO.RenewalOfPassport;
import com.passport_visa_management.Models.POJO.UsersRegistrations;
import com.passport_visa_management.Models.POJO.Visa;

@Component
public class PassportImpl implements IPassport{

	@Autowired
	PassportRepository passportRepository;
	
	@Autowired
	UserRegistrationImpl usersRepository;
	
	@Autowired
	ImplVisa visaRepository;
	
	@Override
	public List<Passport> getAll() {
		return passportRepository.findAll();
	}

	@Override
	public Passport getByPassportId(String passportId) {
		return passportRepository.findById(passportId).get();
	}

	@Override
	public Passport getByUserId(String userId) {
		return getByUserIdAndStatus(userId,"Active");
	}

	@Override
	public String checkExpiryDate(String userId) {
			Passport passport=getByUserIdAndStatus(userId,"Active");
			LocalDate todayDate=LocalDate.now();
			if(passport.getExpiryDate().compareTo(todayDate)>0) {
				if (passport.getIssueDate().isAfter(todayDate)) {
		            return "Passport not issued yet.";
		        }
				return "Your Passport Did not Expired!<br>Your Passport Expires on "+passport.getExpiryDate();		
			}
			return "";
				
	}

	@Override
	public Integer maxPassport() {
		 List<Passport> passports = getAll();	    
		    int maxPassportNumber = 0;		    
		    for (Passport passport : passports) {
		        String passportId = passport.getPassportId();
		        String[] parts = passportId.split("-");  
		        String lastPart = parts[1];
		        String lastFourCharacters = lastPart.substring(lastPart.length() - 4);
		        int passportNumber = Integer.parseInt(lastFourCharacters);
		        if (passportNumber > maxPassportNumber) {
		            maxPassportNumber = passportNumber;
		        }
		    }  
		    return maxPassportNumber;
	}

	@Override
	public String SaveRenewalDetailsToDb(RenewalOfPassport renewalDetails) {
		Passport oldPassport=getByUserIdAndStatus(renewalDetails.getUserId(),"Active");
		Passport renewedPassport=new Passport();
		int maxUserId=maxPassport();
		String newPassportId="FPS-"+renewalDetails.getBookletType()+String.format("%04d",maxUserId+1);
		DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		visaRepository.updateVisas(oldPassport.getPassportId());
		oldPassport.setStatus("InActive");
		renewedPassport.setUserId(oldPassport.getUserId());
		renewedPassport.setPassportId(newPassportId);
		renewedPassport.setBookletType(renewalDetails.getBookletType());
		renewedPassport.setTypeOfService(renewalDetails.getTypeOfService());
		renewedPassport.setPincode(renewalDetails.getPincode());
		renewedPassport.setCountry(oldPassport.getCountry());
		renewedPassport.setState(renewalDetails.getState());
		renewedPassport.setCity(renewalDetails.getCity());
		LocalDate issueDate=LocalDate.now().plusDays(10);
		renewedPassport.setIssueDate(issueDate);
		renewedPassport.setExpiryDate(issueDate.plusYears(10));
		renewedPassport.setStatus("Active");
		passportRepository.save(oldPassport);
		passportRepository.save(renewedPassport);
		int cost = renewalDetails.getTypeOfService().equalsIgnoreCase("Normal") ? 2500 : 5000;
		return "Dear User,<br>Your PassportID is "+newPassportId+"<br>IssueDate is "+issueDate.format(simpleDate)+"<br>Expiry Date is "+issueDate.plusYears(10).format(simpleDate)+"<br>Cost is "+cost;
	}
	public Passport getByUserIdAndStatus(String userId, String status) {
		Passport oldPassport=passportRepository.findByUserIdUserIdAndStatus(userId,status);
		return oldPassport;
	}	
	
	@Override
	public String createpassport(Passport user, String userId) {
				DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
				user.setUserId(usersRepository.getUserById(userId));
				String passportcode = "FPS-" + user.getBookletType() + String.format("%04d", (maxPassport() + 1));
				user.setPincode(user.getPincode());
				LocalDate issueDate=LocalDate.now().plusDays(10);
				user.setIssueDate(issueDate);
				user.setExpiryDate(issueDate.plusYears(10));
				user.setPassportId(passportcode);
				user.setStatus("Active");
				int cost = user.getTypeOfService().equalsIgnoreCase("Normal") ? 2500 : 5000;
				passportRepository.save(user);
				return "Dear User,<br>Your PassportID is "+passportcode+"<br>IssueDate is "+issueDate.format(simpleDate)+"<br>Expiry Date is "+issueDate.plusYears(10).format(simpleDate)+"<br>Cost is "+cost;
		}
	@Override
	public String PassportExists(String userId) {			
			Passport exist_passport = getByUserIdAndStatus(userId,"Active");
			if(exist_passport!=null) {
				return "Passport Already Exists!";				
			}
			return "";	
	}

	@Override
	public String updatePassportAfterLoss(PassportLost passportLost) {
		Passport oldPassport=getByUserId(passportLost.getUserId());
		oldPassport.setExpiryDate(LocalDate.now());
		oldPassport.setStatus("InActive");
		passportRepository.save(oldPassport);	
		Passport newPassport=new Passport();
		int maxUserId=maxPassport();
		String newPassportId="FPS-"+passportLost.getBookletType()+String.format("%04d",maxUserId+1);
		DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		visaRepository.updateVisas(oldPassport.getPassportId());
		oldPassport.setStatus("InActive");
		newPassport.setUserId(oldPassport.getUserId());
		newPassport.setPassportId(newPassportId);
		newPassport.setBookletType(passportLost.getBookletType());
		newPassport.setTypeOfService(passportLost.getTypeOfService());
		newPassport.setPincode(passportLost.getPincode());
		newPassport.setCountry(oldPassport.getCountry());
		newPassport.setState(passportLost.getState());
		newPassport.setCity(passportLost.getCity());
		LocalDate issueDate=LocalDate.now().plusDays(10);
		newPassport.setIssueDate(issueDate);
		newPassport.setExpiryDate(issueDate.plusYears(10));
		newPassport.setStatus("Active");
		passportRepository.save(newPassport);
		int cost = passportLost.getTypeOfService().equalsIgnoreCase("Normal") ? 2500 : 5000;
		return "Dear User,<br>Your PassportID is "+newPassportId+"<br>IssueDate is "+issueDate.format(simpleDate)+"<br>Expiry Date is "+issueDate.plusYears(10).format(simpleDate)+"<br>Cost is "+cost;
	}
	
	
	
}
