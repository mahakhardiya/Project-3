package com.passport_visa_management.Models.DAO.ServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.passport_visa_management.Models.DAO.Services.CostRepository;
import com.passport_visa_management.Models.DAO.Services.IVisa;
import com.passport_visa_management.Models.DAO.Services.IVisaPermit;
import com.passport_visa_management.Models.DAO.Services.PassportRepository;
import com.passport_visa_management.Models.DAO.Services.UsersRepository;
import com.passport_visa_management.Models.DAO.Services.VisaPermitRepository;
import com.passport_visa_management.Models.DAO.Services.VisaRepository;
import com.passport_visa_management.Models.POJO.Cost;
import com.passport_visa_management.Models.POJO.Passport;
import com.passport_visa_management.Models.POJO.UsersRegistrations;
import com.passport_visa_management.Models.POJO.Visa;
import com.passport_visa_management.Models.POJO.VisaApplicationCost;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Parameter;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class ImplVisa implements IVisa,IVisaPermit{

	@Autowired
	VisaRepository visaRepository;
	
	@Autowired
	VisaPermitRepository visaPermitRepository;
	
	@Autowired
	PassportRepository passportRepository;
	
	@Autowired
	UserRegistrationImpl userRegistrationImpl;
	
	@Autowired
	CostRepository costRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Visa insertVisa(Visa v) {
		DateTimeFormatter D=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		List<Visa> list=visaRepository.findAll();
		v.setVisaId("VISA-"+String.format("%04d",list.size()+1));
		
		int expiryYears=(int) visaPermitRepository.findById(v.getOccupation()).get().getVisaPermit();
		v.setIssueDate(v.getDateOfApplication().plusDays(10));
		v.setExpiryDate(v.getDateOfApplication().plusYears(expiryYears));	
		v.setStatus("Active");
		TypedQuery<Integer> query = entityManager.createNamedQuery("VisaApplicationCost.findApplicationCost",Integer.class);
		   query.setParameter("occupation", v.getOccupation());
		   query.setParameter("place", v.getCountry());
		   query.getSingleResult();
		  v.setRegistrationCost(query.getResultList().get(0));
		  
		visaRepository.save(v);
		return v;
	}


	public List<Visa> fetchVisa() {
		// TODO Auto-generated method stub
		return visaRepository.findAll();
	}


	@Override
	public int getPermitYears(String occupation) {
		return 0;
	}

	@Override
	public List<Visa> getByUserIdAndStatus(String userId, String status) {
	
		return visaRepository.findByUserIdAndStatus(userId, status);
	}
	
	@Override
	public List<Visa> getvisa(String passportId) {
		return visaRepository.findAllByPassportIdAndStatus(passportRepository.findById(passportId).get(), "Active" );
	}

	@Override
	public Visa getById(String visaid) {
		// TODO Auto-generated method stub
		return visaRepository.findById(visaid).get();
	}

	@Override
	public Visa updatevisa(Visa V, String visaid) {

		Visa old = getById(visaid);
		old.setStatus("InActive");
		Visa new_obj = visaRepository.save(old);
		return new_obj;
	}

	public Cost findCost(String visaId) {
		// TODO Auto-generated method stub

		Visa visa = visaRepository.findById(visaId).get();
		String occupation = visa.getOccupation();
		LocalDate expiryDate = visa.getExpiryDate();
		LocalDate currentDate = LocalDate.now();

		Period difference_Months = Period.between(currentDate, expiryDate);

		int months;
		if (difference_Months.getMonths() > 6) {
			months = 7;
		} else {
			months = 6;
		}

		Cost cost = costRepository.findByOccupationAndMonths(occupation, months);
		return cost;

	}

	@Override
	public Visa getByPassportId(String passportId) {

		Passport passport = passportRepository.findById(passportId).get();
		Visa visa = visaRepository.findBypassportId(passport);
		return visa;

	}

	@Override
	public UsersRegistrations getUser(String userId) {
		return userRegistrationImpl.getUserById(userId);
	}

	@Override
	public Passport getPassport(String userId) {
		UsersRegistrations user = getUser(userId);
		return passportRepository.findByUserIdUserIdAndStatus(user.getUserId(), "Active");
	}

	@Override
	public String updateVisaStatus(String visaId) {
			Visa visa_obj = getById(visaId);
			visa_obj.setExpiryDate(LocalDate.now());
			visa_obj.setStatus("InActive");
			visaRepository.save(visa_obj);
			return visa_obj.getVisaId();

	}

	@Override
	public List<Visa> getAll() {
		
		return visaRepository.findAll();
	}

	@Override
	public Boolean getNumberOfVisas(String userId, String status) {
		List<Visa> VisaList=visaRepository.findByUserIdAndStatus(userId, status);
		if(VisaList.size()==0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Visa> fetchVisa(String userId) {
		List<Visa> list=visaRepository.findByUserId(userId);
		return list;
	}


	@Override
	public void updateVisas(String passportId) {
		List<Visa> activeVisas=getvisa(passportId);
		for (Visa visa : activeVisas) {
			visa.setExpiryDate(LocalDate.now());
	        visa.setStatus("InActive");
	        visaRepository.save(visa);
	}
	}

}
