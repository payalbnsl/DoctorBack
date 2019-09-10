package com.springboot.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class DoctorResponse  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int doctorId;
	
	@Length(min = 6 ,max = 20)
	String username;
	@Length(min = 6 ,max = 20)

	@Length(min = 3)
	String firstName;
	@Length(min = 3)
	String lastName;
	
	@NotNull
	String speciality;
	@NotNull
	String address;
	


	@Email
	String email;
}
