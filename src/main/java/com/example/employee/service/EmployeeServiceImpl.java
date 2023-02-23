package com.example.employee.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRep;

	@Override
	public ResponseDto registerEmp(EmployeeDto empDto) {
		Employee emp1 = empRep.findEmployeeByempemail(empDto.getEmpemail());
		if (emp1 != null) {
			if (empDto.getEmpemail().equals(emp1.getEmpemail())) {
				return new ResponseDto("Employee Already Registered");
			}
		}
		Employee emp = new Employee();
		emp.setEmpid((long) (Math.floor(Math.random() * 999999) + 100001));
		emp.setEmpname(empDto.getEmpname());
		emp.setEmpemail(empDto.getEmpemail());
		emp.setContactnumber(empDto.getContactnumber());
		emp.setBranch(empDto.getBranch());
		emp.setShift(empDto.getShift());
		emp.setRole(empDto.getRole());
		empRep.save(emp);

		return new ResponseDto("Employee registration is completed");
	}

}
