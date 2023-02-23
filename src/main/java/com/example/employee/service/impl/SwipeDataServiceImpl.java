package com.example.employee.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.Employee;
import com.example.employee.entity.SwipeData;
import com.example.employee.entity.TempSwipeData;
import com.example.employee.exception.AccessDenied;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.exception.SwipedException;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.SwipeDataRepository;
import com.example.employee.repository.TempSwipeDataRepository;
import com.example.employee.service.SwipeDataService;

@Service
@Transactional
public class SwipeDataServiceImpl implements SwipeDataService {

	@Autowired
	SwipeDataRepository swipeDataRepository;

	@Autowired
	TempSwipeDataRepository tempSwipeDataRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger logger = LoggerFactory.getLogger(SwipeDataServiceImpl.class);

	@Override
	public ResponseDto newSwipedData(String email) {
		
		if (employeeRepository.findByemail(email) == null) {
			logger.warn("Employee hasn't registered yet");
			throw new EmployeeNotFoundException("Employee hasn't registered yet");
		}
		Employee employee = employeeRepository.findByemail(email);
		SwipeData swipeData = new SwipeData();
		swipeData.setDate(LocalDate.now());
		swipeData.setSwipeintime(LocalDateTime.now());
		swipeData.setEmployee(employee);
		swipeData.setEmpname(employee.getEmpName());
		swipeData.setSwipeouttime(null);
		swipeData.setEmail(employee.getEmail());
		swipeDataRepository.save(swipeData);
		
		LocalDate swippedDate=swipeDataRepository.findByemail(email).getDate();
		if ( swippedDate==LocalDate.now() && swipeDataRepository.existsByEmail(email) )
			throw new SwipedException("Employeed already swiped In");

		TempSwipeData tempSwipeData = new TempSwipeData();
		tempSwipeData.setEmpid(swipeData.getEmployee().getEmpId());
		tempSwipeData.setTempswipedout(null);
		tempSwipeData.setEmail(employee.getEmail());
		tempSwipeDataRepository.save(tempSwipeData);

		List<String> list = new ArrayList<>();
		list.add("Swiped In Successfully");
		logger.info("Successfull");
		return new ResponseDto(list, 200);

	}


	@Override
	public ResponseDto updateTempSwipedOutDetails(String email) {

		List<String> list = new ArrayList<>();
		if (employeeRepository.findByemail(email) == null) {
			throw new EmployeeNotFoundException("Employee Not found");
		}
		Employee employee = employeeRepository.findByemail(email);
		Optional<TempSwipeData> tempSwipeData = tempSwipeDataRepository.findByempid(employee.getEmpId());
		tempSwipeData.get().setTempswipedout(LocalDateTime.now());
		if (tempSwipeData.isPresent()) {
			TempSwipeData tempSwipeData2 = tempSwipeData.get();
			tempSwipeDataRepository.save(tempSwipeData2);
			list.add("updated successfully");
			logger.info("Swiped details updated successfully");
			return new ResponseDto(list, 200);
		}
		list.add("Could not be updated ");
		logger.warn("Swiped details could not be updated");
		return new ResponseDto(list, 200);
	}

	// scheduled task 	
	@Scheduled(cron = "* 38 12 * * *", zone = "Asia/Kolkata")
	public void updateEntries() {
		logger.warn("Cron Job starts to update the logged out time");
		List<TempSwipeData> list = new ArrayList<>();
		list.addAll(tempSwipeDataRepository.findAll());
		for (TempSwipeData temp : list) {
			SwipeData swipeData = swipeDataRepository.findByemail(temp.getEmail());
			swipeData.setSwipeouttime(temp.getTempswipedout());
			swipeDataRepository.save(swipeData);
			tempSwipeDataRepository.delete(temp);
		}
		logger.info("Cron job ends");
		// runs for one minute continuously can be stopped using application context
	}
	
	
	
	@Override
	public List<SwipeData> searchSwipeData(String email, String fromDate, String toDate) {
		List<SwipeData> list = new ArrayList<>();
		if (employeeRepository.findByemail(email) == null) {
			logger.warn("Employee's Swipe data is not available");
			throw new EmployeeNotFoundException("Employee's Swipe data is not available");
		}
		Employee employee = employeeRepository.findByemail(email);
		
		if (employee.getRole().equals("Admin")) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yyyy");
			LocalDate from = YearMonth.parse(fromDate, formatter).atDay(1);
			LocalDate to = YearMonth.parse(toDate, formatter).atDay(31);
			list.addAll(swipeDataRepository.findAllByDateBetween(from,to));
			if(list.size()==0)
				throw new SwipedException("No employees with swipe history");
			return list;
		}
		else 
			throw new AccessDenied("Employee has no access to view information");
	}


}
