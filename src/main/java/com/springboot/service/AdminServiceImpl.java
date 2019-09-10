package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Admin;
import com.springboot.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository repo;
	
	@Override
	public Admin getUser(String username) {
		return repo.findByUsername(username);
	}

}
