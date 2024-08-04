package com.passport_visa_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.passport_visa_management.Models.DAO.ServiceImpl.ImplVisa;
import com.passport_visa_management.Models.DAO.ServiceImpl.ImplVisaCost;
import com.passport_visa_management.Models.DAO.ServiceImpl.ImplVisaPermit;
import com.passport_visa_management.Models.DAO.ServiceImpl.PassportImpl;

@SpringBootApplication
public class PassportVisaManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassportVisaManagementApplication.class, args);
	}

	@Bean
	public PassportImpl passportImpl(){
		return new PassportImpl();
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
	
	@Bean
	public ImplVisa implVisa()
	{
		return new ImplVisa();
	}
	
	@Bean
	public ImplVisaCost implVisacost()
	{
		return new ImplVisaCost();
	}
	
	@Bean
	public ImplVisaPermit implVisapermit()
	{
		return new ImplVisaPermit();
	}
	
	
}
