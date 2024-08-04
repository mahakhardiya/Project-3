package com.passport_visa_management.Models.POJO;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Users")
public class UsersRegistrations implements Serializable{

	@Id
	@Column(length = 25)
	private String userId;
	@Column(length = 100)
	private String password;
	@Column(length = 25)
	private String firstName;
	@Column(length = 25)
	private String surname;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate dateOfBirth;
	@Column(length = 50)
	private String address;
	@Column(length = 10, unique = true)
	private String contactNumber;
	@Column(length = 35, unique = true)
	private String email;
	@Column(length = 25)
	private String qualification;
	@Column(length = 25)
	private String gender;
	@Column(length = 40)
	private String hintQuestion;
	@Column(length = 20)
	private String hintAnswer;
	@Column(length = 10)
	private String citizenType;
	@Column(length = 2)
	private String status;

	public UsersRegistrations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersRegistrations(String userId, String password, String firstName, String surname, LocalDate dateOfBirth,
			String address, String contactNumber, String email, String qualification, String gender,
			String hintQuestion, String hintAnswer, String citizenType, String status) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
		this.qualification = qualification;
		this.gender = gender;
		this.hintQuestion = hintQuestion;
		this.hintAnswer = hintAnswer;
		this.citizenType = citizenType;
		this.status = status;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHintQuestion() {
		return hintQuestion;
	}

	public void setHintQuestion(String hintQuestion) {
		this.hintQuestion = hintQuestion;
	}

	public String getHintAnswer() {
		return hintAnswer;
	}

	public void setHintAnswer(String hintAnswer) {
		this.hintAnswer = hintAnswer;
	}

	public String getCitizenType() {
		return citizenType;
	}

	public void setCitizenType(String citizenType) {
		this.citizenType = citizenType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
