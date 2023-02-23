package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.SwipeData;
import com.example.employee.service.impl.SwipeDataServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController("/api/employee-attendance")
public class SwipeDataController {

	@Autowired
	SwipeDataServiceImpl swipeDataServiceImpl;

	@Operation(summary = "new swiped data")
	@PostMapping("/")
	public ResponseEntity<ResponseDto> newSwipedData(@RequestParam String email) {
		return new ResponseEntity<>(swipeDataServiceImpl.newSwipedData(email), HttpStatus.CREATED);
	}

	@Operation(summary = "update the logged out time")
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateTempSwipedOutDetails(@RequestParam String email) {
		return new ResponseEntity<>(swipeDataServiceImpl.updateTempSwipedOutDetails(email), HttpStatus.OK);
	}

	@Operation(summary = "search by admin")
	@GetMapping("/")
	public ResponseEntity<List<SwipeData>> searchSwipeDataWithRangeOfDate(@RequestParam String adminEmail,
			@RequestParam String fromDate, @RequestParam String toDate) {
		return new ResponseEntity<>(swipeDataServiceImpl.searchSwipeData(adminEmail,fromDate,toDate),HttpStatus.OK);
	}

}
