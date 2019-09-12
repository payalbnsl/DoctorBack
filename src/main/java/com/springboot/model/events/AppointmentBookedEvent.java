package com.springboot.model.events;

public class AppointmentBookedEvent extends AppointmentEvent {
	
	String paymentStatus;

	public AppointmentBookedEvent(Object source, String message) {
		super(source, message);
		
	}

	

}
