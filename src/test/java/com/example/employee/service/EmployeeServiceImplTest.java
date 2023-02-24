package com.example.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl empservimpl;

	@Mock
	EmployeeRepository empRep;

	@Test
	public void registerEmpTest() {
		Employee emp = new Employee();
		emp.setEmpId(887632);
		emp.setEmpName("Dksha");
		emp.setEmail("d4@gmail.com");
		emp.setContactNumber("8114321345");
		emp.setBranch("IT");
		emp.setShift("N");
		emp.setRole("Admin");
		Mockito.when(empRep.save(emp)).thenReturn(emp);
		assertNotNull(emp);
	}

	@Test
	public void CreateEntryTest() {
		EmployeeDto empDto1 = null;
		assertNull(empDto1);

	}

}
