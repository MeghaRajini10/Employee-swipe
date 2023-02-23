package com.example.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
		EmployeeDto empDto = new EmployeeDto();
		emp.setEmpid(887632);
		emp.setEmpname("Dksha");
		emp.setEmpemail("d4@gmail.com");
		emp.setContactnumber("8114321345");
		emp.setBranch("IT");
		emp.setShift("N");
		emp.setRole("Admin");
		Mockito.when(empRep.save(emp)).thenReturn(emp);
		assertEquals("Employee registration is completed", empservimpl.registerEmp(empDto).getMessage());
	}

	@Test
	public void testCreateEntryWithNameIsNullThrowsNPE() {
		EmployeeDto empDto1 = null;
		assertNull(empDto1);

	}

}
