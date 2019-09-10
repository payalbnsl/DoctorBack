package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Admin;
import com.springboot.model.Appointment;
import com.springboot.model.Doctor;
import com.springboot.model.Leave;
import com.springboot.service.AdminService;
import com.springboot.service.AppointmentService;
import com.springboot.service.DoctorService;
import com.springboot.service.LeaveService;

@RestController
public class AdminController {
	
	
	
	@Autowired 
	AdminService service;
	@Autowired
	DoctorService dService;
	@Autowired
	AppointmentService aService;
	@Autowired
	LeaveService lService;
	
	
	@PostMapping("/admin/login")
	public Admin doctorLogin(@RequestBody Admin a) {

		System.err.println("admin login ");
		Admin admin = service.getUser(a.getUsername());
		if(admin == null) {
			System.err.println("username not found");
		} else if (!admin.getPassword().equals(admin.getPassword())){
			System.err.println("password does not match");
		} else {
			return admin;
		}
		
		return null;
	}
	
	@GetMapping("/admin/doctors")
	public List<Doctor> getDoctors(){
		System.err.println("admin doctors");
		return dService.getDoctors();
	}
	
	@DeleteMapping("/admin/doctors/{id}")
	public void deleteDoctor(@PathVariable int id) {
		System.err.println("Deleting Doctor");
		dService.deleteDoctor(id);
	}
	
	
	@GetMapping("/admin/appointments")
	public List<Appointment> getAppointments(){
		System.err.println("admin appointments");
		return aService.getAllApointment();
	}
	
	@PostMapping("admin/addDoctor")
	public void insertDoctor(@RequestBody Doctor doctor) {
		dService.insertDoctor(doctor);
	}
	
	@GetMapping("admin/leave")
	public List<Leave> doctorLeave() {
		return lService.getAllLeave();
	}

	@PutMapping("admin/leave")
	public void doctorUpdate(@RequestBody Leave leave) {
		lService.updateLeave(leave);
	}
	
	

}
