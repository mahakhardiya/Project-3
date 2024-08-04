package com.passport_visa_management.Models.DAO.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passport_visa_management.Models.POJO.Passport;
import com.passport_visa_management.Models.POJO.Visa;
import com.passport_visa_management.Models.POJO.VisaPermit;

public interface VisaRepository extends JpaRepository<Visa, String>{
	Visa findBypassportId (Passport passport);
	List<Visa> findAllByPassportIdAndStatus(Passport passport, String status);
	public List<Visa> findByUserIdAndStatus(String userId,String status);
	public List<Visa> findByUserId(String userId);//Repo
}
