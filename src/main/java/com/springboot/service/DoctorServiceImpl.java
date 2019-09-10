package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Doctor;
import com.springboot.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	
	@Autowired
	DoctorRepository repo;
	
	
	@Override
	public List<Doctor> getDoctors() {
		
		return repo.findAll();
	}

	@Override
	public void deleteDoctor(int id) {
		repo.deleteById(id);
	}

	@Override
	public int insertDoctor(Doctor doctor) {
		Doctor d=repo.save(doctor);
		return d.getDoctorId();
	}

	@Override
	@Transactional()
	public void updateDoctor(Doctor doctor) {
		repo.save(doctor);
	}

	@Override
	public List<Doctor> getDoctor(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public Optional<Doctor> getDoctor(int id) {
		return repo.findById(id);
	}
	@Override
	public List<Doctor> searchDoctors(String location, String speciality) {
		return repo.findByAddressContainingAndSpeciality(location, speciality);
	}

	@Override
	public List<Doctor> getDoctors(int page, int limit) {
		return repo.findAll(PageRequest.of(page, limit, Direction.ASC,"firstName","lastName")).getContent();
	}
	
	
	
}
