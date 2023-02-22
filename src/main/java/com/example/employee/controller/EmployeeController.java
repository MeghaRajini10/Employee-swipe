package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.SwipeData;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.SwipeDataService;

@RestController
public class EmployeeController {
	@Autowired
	SwipeDataService swipeDataService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@GetMapping("/{empid}")
	public List<SwipeData> search(@PathVariable long empid){
		return swipeDataService.search(empid);
	}
	
	@GetMapping("/search")
	public String getAll(SwipeData swipeData,@PathVariable long empid) {
		return employeeService.getAll(swipeData,empid);
	}
	

}
