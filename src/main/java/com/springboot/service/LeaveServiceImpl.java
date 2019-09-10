package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Leave;
import com.springboot.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService{

	@Autowired
	LeaveRepository repo;
	
	@Override
	public void insertLeave(Leave leave) {
		
		repo.save(leave);
		
	}

	@Override
	public void updateLeave(Leave leave) {
		repo.save(leave);
		
	}

	@Override
	public List<Leave> getAllLeave() {
		return repo.findAll();
	}

}
