package com.springboot.model.events;

public class AppointmentInitatedEvent extends AppointmentEvent {

	
	public AppointmentInitatedEvent(AppointmentInitatedRecord record, String message) {
		super(record,message);
		
	}

	

}
