package com.passport_visa_management.Models.DAO.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.passport_visa_management.Models.POJO.UsersRegistrations;

@Repository
public interface UsersRepository extends JpaRepository<UsersRegistrations,String>{
	UsersRegistrations findByEmailIs (String email);
	UsersRegistrations findByContactNumberIs (String number);
}
