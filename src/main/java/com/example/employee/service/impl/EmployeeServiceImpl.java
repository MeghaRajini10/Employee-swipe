package com.example.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public ResponseDto registerEmp(EmployeeDto empDto) {
		List<String> list = new ArrayList<>();
		Employee emp1 = empRepository.findByemail(empDto.getEmpemail());
		if (emp1 != null) {
			if (empDto.getEmpemail().equals(emp1.getEmail())) {
				list.add("Employee Already Registered");
				return new ResponseDto(list,404);
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
		empRepository.save(emp);
		
		list.add("Employee registration is completed");
		return new ResponseDto(list,200);
	}

}
