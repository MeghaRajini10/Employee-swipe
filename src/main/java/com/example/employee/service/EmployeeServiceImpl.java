package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.exception.EmployeeAlreadyExistsException;
import com.example.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public Employee registerEmp(EmployeeDto empDto) {
		Employee emp1 = empRepository.findByemail(empDto.getEmpemail());
		if (emp1 != null) {
			if (empDto.getEmpemail().equals(emp1.getEmail())) {
				throw new EmployeeAlreadyExistsException("Employee Already registered");
			}
		}
		Employee emp = new Employee();
		emp.setEmpId((int) (Math.floor(Math.random() * 999999) + 100001));
		emp.setEmpName(empDto.getEmpname());
		emp.setEmail(empDto.getEmpemail());
		emp.setContactNumber(empDto.getContactnumber());
		emp.setBranch(empDto.getBranch());
		emp.setShift(empDto.getShift());
		emp.setRole(empDto.getRole());
		return empRepository.save(emp);
		
	
	}

}