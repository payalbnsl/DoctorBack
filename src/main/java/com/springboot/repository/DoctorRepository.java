package com.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	public List<Doctor> findByUsername(String username);
	
	
	public List<Doctor> findByAddressContainingAndSpeciality(String address, String speciality);
	
/*	@Qu
	public List<Doctor> getDoctorSortedByName(Pageable page);*/
}
