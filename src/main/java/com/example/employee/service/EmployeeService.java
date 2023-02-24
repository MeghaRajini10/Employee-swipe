package com.example.employee.service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;

public interface EmployeeService {
	Employee registerEmp(EmployeeDto empDto);

}
