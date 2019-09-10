package com.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Patient;
import com.springboot.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{

	
	@Autowired PatientRepository repo;
	
	@Override
	public Patient getUser(String username) {
		
		return repo.findByUsername(username); 
	}

	@Override
	public Patient getUser(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void updatePatient(Patient p) {
		repo.save(p);
		
	}

}
