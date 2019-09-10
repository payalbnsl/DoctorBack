package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	public List<Appointment> findByDoctorid(int doctorid);
	public List<Appointment> findByPatientid(int patientid);
	
}
