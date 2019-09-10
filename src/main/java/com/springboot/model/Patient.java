package com.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName, lastName;
	
	@Length(min = 6,max = 20)
	private String username;
	private String password;
	
	private String email;

	public Patient(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	
}
