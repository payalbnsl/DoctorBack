package com.springboot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Doctor_Leave")
public class Leave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int leaveId;
	
	@NotNull
	int doctorid;
	@NotNull
	String doctorName;
	@NotNull
	LocalDate leaveDate, endDate;
	
	String reason;
	@NotNull
	String status;

	public Leave() {}



	public int getLeaveId() {
		return leaveId;
	}



	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}



	public int getDoctorid() {
		return doctorid;
	}



	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}



	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}



	public LocalDate getLeaveDate() {
		return leaveDate;
	}



	public void setLeaveDate(LocalDate leaveDate) {
		this.leaveDate = leaveDate;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
