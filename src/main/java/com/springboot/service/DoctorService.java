package com.springboot.service;

import java.util.List;
import java.util.Optional;

import com.springboot.model.Doctor;

public interface DoctorService {
	
	
	public List<Doctor> getDoctors();
	
	public List<Doctor> getDoctor(String username);
	
	public void deleteDoctor(int id);
	
	public int insertDoctor(Doctor doctor);
	
	public void updateDoctor(Doctor doctor);
	
	public List<Doctor> searchDoctors(String location, String speciality);

	Optional<Doctor> getDoctor(int id);

	public List<Doctor> getDoctors(int page, int limit);
	
	

}
