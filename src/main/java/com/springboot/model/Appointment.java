package com.springboot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
	@NotNull
	private LocalDate date;
	@NotNull
	private String time;
	
	@NotNull
	private int doctorid;
	
	private int patientid;

	@NotNull
	private String doctorName;
	
	private String patientName;
	
	
	
	
	
}
