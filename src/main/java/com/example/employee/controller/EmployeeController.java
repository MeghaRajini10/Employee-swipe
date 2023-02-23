package com.example.employee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.service.impl.EmployeeServiceImpl;

@RestController("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empServ;
	
	
	@PostMapping()
	public ResponseEntity<ResponseDto> registerEmployee(@RequestBody @Valid EmployeeDto empDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(empServ.registerEmp(empDto));
	}

}
