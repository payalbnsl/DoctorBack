package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer>{

	Leave findByDoctorid(int id);
	
}
