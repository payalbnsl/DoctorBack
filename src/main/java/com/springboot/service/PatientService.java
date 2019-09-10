package com.springboot.service;

import com.springboot.model.Patient;

public interface PatientService {
	
	public Patient getUser(String username);
	
	public Patient getUser(int id);
	
	public void updatePatient(Patient p);
	

}
