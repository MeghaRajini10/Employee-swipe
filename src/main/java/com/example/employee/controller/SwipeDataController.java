package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.ResponseDto;
import com.example.employee.service.impl.SwipeDataServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController("/api/employee-attendance")
public class SwipeDataController {
	
	@Autowired
	SwipeDataServiceImpl swipeDataServiceImpl;
	

	
	@Operation(summary = "new swiped data")
	@PostMapping("/")
	public ResponseEntity<ResponseDto> newSwipedData(@RequestParam String email){
		return new ResponseEntity<>(swipeDataServiceImpl.newSwipedData(email),HttpStatus.CREATED);
	}

	@Operation(summary = "update the logged out time")
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateTempSwipedOutDetails(@RequestParam  String email){
		return new ResponseEntity<>(swipeDataServiceImpl.updateTempSwipedOutDetails(email),HttpStatus.OK);
	}
	
	
}
