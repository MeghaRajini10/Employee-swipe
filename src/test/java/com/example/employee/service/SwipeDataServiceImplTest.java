package com.example.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.entity.SwipeData;
import com.example.employee.entity.TempSwipeData;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.SwipeDataRepository;
import com.example.employee.repository.TempSwipeDataRepository;
import com.example.employee.service.impl.SwipeDataServiceImpl;

@ExtendWith(SpringExtension.class)
public class SwipeDataServiceImplTest {

	@InjectMocks
	SwipeDataServiceImpl swipeDataServiceImpl;

	@Mock
	SwipeDataRepository swipeDataRepository;

	@Mock
	EmployeeRepository employeeRepository;
	@Mock
	TempSwipeDataRepository tempSwipeDataRepository;

	@Test
    void testNewSwipedDataPositive() {
        String email = "test@example.com";
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("John Doe");
        employee.setEmail(email);

        Mockito.when(employeeRepository.findByemail(email)).thenReturn(employee);

        ResponseDto response = swipeDataServiceImpl.newSwipedData(email);

        assertNotNull(response);
        assertEquals(200, response.getCode());
        assertEquals("Swiped In Successfully", response.getMessages().get(0));
    }
	
	
	@Test
	void testNewSwipedDatawithNull() {
		String email = "test@example.com";
		 assertThrows(EmployeeNotFoundException.class, () -> {
		        swipeDataServiceImpl.newSwipedData(email);
		    });
	}
	
	@Test
	public void testUpdateTempSwipedOutDetailsWithValidData() {
	    // Arrange
	    String email = "validemployee@example.com";
	    Employee employee = new Employee();
	    employee.setEmail(email);
	    employee.setEmpId(1);
	    TempSwipeData tempSwipeData = new TempSwipeData();
	    tempSwipeData.setEmail(email);
	    tempSwipeData.setEmpid(1);
	    tempSwipeData.setTempswipedout(null);
	    when(employeeRepository.findByemail(email)).thenReturn(employee);
	    when(tempSwipeDataRepository.findByempid(employee.getEmpId())).thenReturn(Optional.of(tempSwipeData));
	    when(tempSwipeDataRepository.save(tempSwipeData)).thenReturn(tempSwipeData);

	    ResponseDto response = swipeDataServiceImpl.updateTempSwipedOutDetails(email);
	    assertEquals(response.getCode(), 200);
	    assertEquals(response.getMessages().get(0), "updated successfully");
	}

	@Test
	public void givenInvalidEmail_whenUpdateTempSwipedOutDetails_thenThrowEmployeeNotFoundException() {
	    String email = "invalid.email@example.com";
	    when(employeeRepository.findByemail(email)).thenReturn(null);

	    // Act & Assert
	    Exception exception = assertThrows(EmployeeNotFoundException.class, () -> {
	        swipeDataServiceImpl.updateTempSwipedOutDetails(email);
	    });

	    assertEquals("Employee Not found", exception.getMessage());
	    verify(employeeRepository).findByemail(email);
	}

	@Test
	public void testUpdateEntries() {
	    // Arrange
	    List<TempSwipeData> tempSwipeDataList = new ArrayList<>();
	    TempSwipeData tempSwipeData1 = new TempSwipeData();
	    tempSwipeData1.setEmail("employee1@example.com");
	    tempSwipeData1.setEmpid(1);
	    tempSwipeData1.setTempswipedout(LocalDateTime.now());
	    tempSwipeDataList.add(tempSwipeData1);
	    TempSwipeData tempSwipeData2 = new TempSwipeData();
	    tempSwipeData2.setEmail("employee2@example.com");
	    tempSwipeData2.setEmpid(2);
	    tempSwipeData2.setTempswipedout(LocalDateTime.now());
	    tempSwipeDataList.add(tempSwipeData2);
	    when(tempSwipeDataRepository.findAll()).thenReturn(tempSwipeDataList);
	    Employee employee1 = new Employee();
	    employee1.setEmail("employee1@example.com");
	    Employee employee2 = new Employee();
	    employee2.setEmail("employee2@example.com");
	    when(employeeRepository.findByemail("employee1@example.com")).thenReturn(employee1);
	    when(employeeRepository.findByemail("employee2@example.com")).thenReturn(employee2);
	    SwipeData swipeData1 = new SwipeData();
	    swipeData1.setEmail("employee1@example.com");
	    SwipeData swipeData2 = new SwipeData();
	    swipeData2.setEmail("employee2@example.com");
	    when(swipeDataRepository.findByemail("employee1@example.com")).thenReturn(swipeData1);
	    when(swipeDataRepository.findByemail("employee2@example.com")).thenReturn(swipeData2);

	    // Act
	    swipeDataServiceImpl.updateEntries();

	    // Assert
	    verify(swipeDataRepository).save(swipeData1);
	    verify(swipeDataRepository).save(swipeData2);
	    verify(tempSwipeDataRepository).delete(tempSwipeData1);
	    verify(tempSwipeDataRepository).delete(tempSwipeData2);
	}





}
