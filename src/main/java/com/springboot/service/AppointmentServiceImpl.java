package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Appointment;
import com.springboot.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	
	@Autowired
	AppointmentRepository repo;
	
	@Override
	public void insertAppointment(Appointment a) {	
		repo.save(a);
	}

	@Override
	public List<Appointment> getAppointmentByDoctor(int doctorid) {
		
		return repo.findByDoctorid(doctorid);
	}

	@Override
	public List<Appointment> getAllApointment() {
		
		return repo.findAll();
	}

	@Override
	public List<Appointment> getAppointmentByPatient(int patientid) {
		
		return repo.findByPatientid(patientid);
	}

	
}
