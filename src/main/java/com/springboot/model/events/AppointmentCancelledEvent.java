package com.springboot.model.events;

public class AppointmentCancelledEvent  extends AppointmentEvent{

	String reason;//payment_failed/ db_issue
	public AppointmentCancelledEvent(Object source, String message) {
		super(source, message);
		
	}
}
