package com.springboot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.Appointment;
import com.springboot.model.Doctor;
import com.springboot.model.Leave;
import com.springboot.service.AppointmentService;
import com.springboot.service.LeaveService;

@RequestMapping("/doctors/{doctorId}")
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	LeaveService leaveService;

	@PostMapping("/appointments")
	public void createAppointment(@RequestBody Appointment appointment) {
		appointmentService.insertAppointment(appointment);
	}

	@GetMapping("/appointments")
	public List<Appointment> getAppointment(@RequestBody Doctor d) {
		return appointmentService.getAppointmentByDoctor(d.getDoctorId());
	}

	@PostMapping("/applyLeave")
	public void applyLeave(@RequestBody Leave leave) {
		
		if(leave.getEndDate().isAfter(leave.getLeaveDate()) && leave.getLeaveDate().isAfter(LocalDate.now())) {
			leave.setStatus("Pending");
			leaveService.insertLeave(leave);
		} else {
			System.err.println("Check your Dates Info");
		}
	}
		
}
