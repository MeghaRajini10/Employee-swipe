package com.example.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.SwipeData;
import com.example.employee.service.impl.EmployeeServiceImpl1;
import com.example.employee.service.impl.SwipeDataServiceImpl;


@RestController("/api/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeServiceImpl1 empServ;
	@Autowired
	private SwipeDataServiceImpl swipeServ;
	
	
//	@PostMapping()
//	public ResponseEntity<ResponseDto> registerEmployee(@RequestBody @Valid EmployeeDto empDto) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(empServ.registerEmp(empDto));
//	}
	@GetMapping("/search")
	public List<SwipeData> searchSwipeData(@RequestParam String email, @RequestParam String fromDate,@RequestParam String toDate){
		return (List<SwipeData>) ResponseEntity.status(HttpStatus.CREATED).body(swipeServ.searchSwipeData(email, fromDate, toDate));
	}
	
	

}
