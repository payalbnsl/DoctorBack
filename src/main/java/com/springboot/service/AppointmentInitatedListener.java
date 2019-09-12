package com.springboot.service;

import org.springframework.context.ApplicationListener;

import com.springboot.model.events.AppointmentInitatedEvent;

public class AppointmentInitatedListener implements ApplicationListener<AppointmentInitatedEvent>{

	@Override
	public void onApplicationEvent(AppointmentInitatedEvent event) {
		//save the event in db (appointmnet events)
		//fails
	}
//book the event: 
}
