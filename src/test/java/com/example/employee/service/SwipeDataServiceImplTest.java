package com.example.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.entity.SwipeData;
import com.example.employee.entity.TempSwipeData;
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
    public void testNewSwipedDataPositive() {
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

        ArgumentCaptor<SwipeData> swipeDataCaptor = ArgumentCaptor.forClass(SwipeData.class);
        Mockito.verify(swipeDataRepository).save(swipeDataCaptor.capture());
        SwipeData capturedSwipeData = swipeDataCaptor.getValue();
        assertEquals(LocalDate.now(), capturedSwipeData.getDate());
        assertNotNull(capturedSwipeData.getSwipeintime());
        assertEquals(employee, capturedSwipeData.getEmployee());
        assertEquals(employee.getEmpName(), capturedSwipeData.getEmpname());
        assertNull(capturedSwipeData.getSwipeouttime());
        assertEquals(email, capturedSwipeData.getEmail());

        ArgumentCaptor<TempSwipeData> tempSwipeDataCaptor = ArgumentCaptor.forClass(TempSwipeData.class);
        Mockito.verify(tempSwipeDataRepository).save(tempSwipeDataCaptor.capture());
        TempSwipeData capturedTempSwipeData = tempSwipeDataCaptor.getValue();
        assertEquals(employee.getEmpId(), capturedTempSwipeData.getEmpid());
        assertNull(capturedTempSwipeData.getTempswipedout());
        assertEquals(email, capturedTempSwipeData.getEmail());
    }

}
