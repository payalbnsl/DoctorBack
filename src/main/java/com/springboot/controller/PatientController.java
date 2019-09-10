/*package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Appointment;
import com.springboot.model.Doctor;
import com.springboot.model.Patient;
import com.springboot.service.AppointmentService;
import com.springboot.service.DoctorService;
import com.springboot.service.PatientService;

@RestController
public class PatientController {
	
	
	@Autowired PatientService service;
	@Autowired DoctorService dService;
	@Autowired AppointmentService aService;

	
	@PostMapping("/patient/login")
	public Patient doctorLogin(@RequestBody Patient d) {

		
		Patient p = service.getUser(d.getUsername());
		if(p == null) {
			System.err.println("username not found");
		} else if (!p.getPassword().equals(d.getPassword())){
			System.err.println("password does not match");
		} else {
			return p;
		}
		return null;
	}
	
	@GetMapping("/patient/getAppointment/{id}")
	public List<Appointment> getAppointment(@PathVariable int id){
		return aService.getAppointmentByPatient(id);
	}
	
	@GetMapping("/patient/getPatient/{id}")
	public Patient getPatient(@PathVariable int id) {
		return service.getUser(id);
	}
	
	@PutMapping("/patient/updatePatient")
	public void update(@RequestBody Patient p) {
		service.updatePatient(p);
	}
	
	@GetMapping("patient/getDoctor")
	public List<Doctor> getDoctor(@PathParam("speciality") String speciality,
			@PathParam("location") String location){
		return dService.searchDoctors(location, speciality);
	}
	
	@GetMapping("patient/getDoctorAppointments/{id}")
	public List<Appointment> getDoctorAppointments(@PathVariable int id){
		System.out.println("doctot app");
		List<Appointment> app = aService.getAppointmentByDoctor(id);
		List<Appointment> result = new ArrayList<>();
		
		for(Appointment a : app) {
			if(a.getPatientName() == null || a.getPatientName().isEmpty()) result.add(a);
		}
		
		return result;
	}
	
	
	@PutMapping("/patient/updateAppointment")
	public void updateAppointment(@RequestBody Appointment appointment) {
		aService.insertAppointment(appointment);
	}
	
	@PostMapping("patient/signup")
	public Patient signUp(@RequestBody Patient d) {
		
		Patient p = service.getUser(d.getUsername());
		
		if(p == null) {
		
			service.updatePatient(d);
			return d;
		
		}
		
		return null;
		
	}
	
	
	
	


}
*/