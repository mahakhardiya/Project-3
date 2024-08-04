package com.techwave.Models.Pojos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import com.techwave.Models.BAO.dobValidate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@dobValidate(message = "DOB must be less than today's date")
public class UsersRegistrations {

	private String userId;

	private String password;

	@NotBlank(message = "*Required")
	private String firstName;
	@NotBlank(message = "*Required")
	private String surname;
	@NotNull(message = "*Required")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;
	@Size(min = 5, max = 30, message = "Address must be between 5 and 30 character")
	private String address;
	@Size(min = 10,max=10, message = "Phone number should be 10-digits")
	private String contactNumber;
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Invalid Email address")
	private String email;
	
	private String qualification;
	@NotBlank(message = "*Required")
	private String gender;
	@NotBlank(message = "*Required")
	private String hintQuestion;
	@Size(min = 5, max = 20, message = "Hint answer must be between 5 and 20 character")
	private String hintAnswer;
	private String citizenType;
	private String status;

	public UsersRegistrations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersRegistrations(String userId, String password, @NotBlank(message = "*Required") String firstName,
			@NotBlank(message = "*Required") String surname, @NotNull(message = "*Required") LocalDate dateOfBirth,
			@Size(min = 5, max = 30, message = "Address must be between 5 and 30 character") String address,
			@Size(min = 10,max = 10, message = "Phone number should be 10-digits") String contactNumber,
			@NotBlank(message = "*Required") @Email String email, String qualification,
			@NotBlank(message = "*Required") String gender, @NotBlank(message = "*Required") String hintQuestion,
			@Size(min = 5, max = 20, message = "Hint answer must be between 5 and 20 character") String hintAnswer,
			String citizenType, String status) {
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
