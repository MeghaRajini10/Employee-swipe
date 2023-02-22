package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.employee.entity.SwipeData;

public interface SwipeDataRepository extends JpaRepository<SwipeData, Long> {
	List<SwipeData> findByEmpid(long empid);
	
	

}
