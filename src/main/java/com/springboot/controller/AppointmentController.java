package com.springboot.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.Appointment;
import com.springboot.model.Doctor;
import com.springboot.model.Leave;
import com.springboot.model.events.AppointmentBookedEvent;
import com.springboot.model.events.AppointmentInitatedEvent;
import com.springboot.model.events.AppointmentInitatedRecord;
import com.springboot.service.AppointmentService;
import com.springboot.service.LeaveService;

@RequestMapping("/doctors/{doctorId}")
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;
	@Autowired
	LeaveService leaveService;
	 @Autowired
	    private ApplicationEventPublisher applicationEventPublisher;

	@PostMapping("/appointments")
	public void createAppointment(@RequestBody Appointment appointment) {
		AppointmentInitatedRecord record= new AppointmentInitatedRecord();
		record.setAppointmentTime(LocalDateTime.of(appointment.getDate(), appointment.getTime()));
		applicationEventPublisher.publishEvent(new AppointmentInitatedEvent(record,"Appointment initated for "+ appointment));//insert record into event table
		appointmentService.insertAppointment(appointment);
		applicationEventPublisher.publishEvent(new AppointmentBookedEvent(this,"Appointment initated for "+ appointment));
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
