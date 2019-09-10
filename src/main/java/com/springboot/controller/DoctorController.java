package com.springboot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Doctor;
import com.springboot.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	DoctorService service;

	/*
	 * @PostMapping("/doctor/login") public Doctor doctorLogin(@RequestBody Doctor
	 * d) {
	 * 
	 * 
	 * Doctor doc = service.getDoctor(d.getUsername()); if(doc == null) {
	 * System.err.println("username not found"); } else if
	 * (!doc.getPassword().equals(d.getPassword())){
	 * System.err.println("password does not match"); } else { return doc; } return
	 * null; }
	 */
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@RequestBody Doctor d, @PathVariable int id) {
		d.setDoctorId(id);
		service.updateDoctor(d);

	}

	// content-type as json/xml, then this method would be called
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity addDoctor(@RequestBody Doctor d, HttpServletRequest request) throws URISyntaxException {
		int id = service.insertDoctor(d);
		return ResponseEntity.created(new URI(request.getRequestURL() + "/" + id)).build();
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@PathVariable int id) {
		service.deleteDoctor(id);

	}

	// request with Accept as xml: this method will return xml data
	// request with html as accept: this method would not be called : media type not
	// supported
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Doctor> getDoctorDetails(@PathVariable int id)
			throws NoSuchMethodException, SecurityException {
		Optional<Doctor> d = service.getDoctor(id);
		Doctor doctor = null;
		if (d.isPresent()) {
			doctor = d.get();
			Link link = ControllerLinkBuilder
					.linkTo(AppointmentController.class,AppointmentController.class.getDeclaredMethod("getAppointment", Doctor.class),id)
					.withRel("appointments").expand();
			doctor.add(link);
		} else {
			doctor = new Doctor();
		}
		return ResponseEntity.ok(doctor);
	}

	@GetMapping(params = { "location", "speciality" }, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Doctor>> searchDoctorDetails(@RequestParam String location,
			@RequestParam String speciality) {
		List<Doctor> doctors = service.searchDoctors(location, speciality);
		return ResponseEntity.ok(doctors);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Doctor>> getDoctors(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int limit) {
		List<Doctor> doctors = service.getDoctors(page, limit);
		for(Doctor d: doctors) {
			//add link
		}
		return ResponseEntity.ok(doctors);
	}
}
