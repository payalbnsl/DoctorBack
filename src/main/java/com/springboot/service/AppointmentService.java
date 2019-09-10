package com.springboot.service;

import java.util.List;

import com.springboot.model.Appointment;

public interface AppointmentService {

	public void insertAppointment(Appointment a);
	
	public List<Appointment> getAppointmentByDoctor(int doctorid);
	
	public List<Appointment> getAppointmentByPatient(int patientid);
	
	public List<Appointment> getAllApointment();
	
}
