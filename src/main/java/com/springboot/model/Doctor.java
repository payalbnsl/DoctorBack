package com.springboot.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Data;

@Data
@Entity

public class Doctor extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int doctorId;
	
	@Length(min = 6 ,max = 20)
	String username;
	@Length(min = 6 ,max = 20)
//	@JsonIgnore
	String password;
	@Length(min = 3)
	String firstName;
	@Length(min = 3)
	String lastName;
	
	@NotNull
	String speciality;
	@NotNull
	@Embedded
	Address address;
	


	@Email
	String email;
	
	
	


}
