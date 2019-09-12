package com.springboot.model.events;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentInitatedRecord {
	String userId;
	String doctorId;
	LocalDateTime appointmentTime;
	String disease;
}
