package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.model.Patient;

@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	// /patients/search?username=
	public Patient findByUsername(String username);

}
