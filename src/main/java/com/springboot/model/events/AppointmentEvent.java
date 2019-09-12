package com.springboot.model.events;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationEvent;

public class AppointmentEvent extends ApplicationEvent{
private static final long serialVersionUID = 4989343456185541261L;
	
	private String message;
	int appointmentId;
	LocalDateTime time;
	 
	    public AppointmentEvent( Object source,String message) {
	        super(source);
	        this.message = message;
	    }
	    public String getMessage() {
	        return message;
	    }
}
