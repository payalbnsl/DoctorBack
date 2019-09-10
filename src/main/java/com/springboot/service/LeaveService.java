package com.springboot.service;

import java.util.List;

import com.springboot.model.Leave;

public interface LeaveService {

	public void insertLeave(Leave leave);
	
	public void updateLeave(Leave leave);
	
	public List<Leave> getAllLeave();
	
	
}
