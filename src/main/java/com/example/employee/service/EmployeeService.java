package com.example.employee.service;


import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;

public interface EmployeeService {
	ResponseDto registerEmp(EmployeeDto empDto);

}
