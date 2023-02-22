package com.example.employee.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.employee.dto.ResponseDto;
import com.example.employee.dto.SwipeDataDto;
import com.example.employee.entity.Employee;
import com.example.employee.entity.SwipeData;
import com.example.employee.entity.TempSwipeData;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.SwipeDataRepository;
import com.example.employee.repository.TempSwipeDataRepository;
import com.example.employee.service.SwipeDataService;

@Service
public class SwipeDataServiceImpl implements SwipeDataService {

	@Autowired
	SwipeDataRepository swipeDataRepository;

	@Autowired
	TempSwipeDataRepository tempSwipeDataRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public ResponseDto newSwipedData(SwipeDataDto swipeDataDto) {
		SwipeData swipeData = new SwipeData();
		Employee employee = employeeRepository.findByemail(swipeDataDto.getEmpemail());
		swipeData.setEmployee(employee);
		swipeData.setEmpname(employee.getEmpName());
		BeanUtils.copyProperties(swipeDataDto, swipeData);
		swipeData.setSwipeouttime(null);
		TempSwipeData tempSwipeData = new TempSwipeData();
		tempSwipeData.setEmpid(swipeData.getEmployee().getEmpid());
		tempSwipeData.setTempswipedout(null);
		swipeDataRepository.save(swipeData);
		tempSwipeDataRepository.save(tempSwipeData);
		List<String> list = new ArrayList<>();
		list.add("Swiped In Successfully");
		return new ResponseDto(list, 200);

	}

	@Override
	public ResponseDto updateTempSwipedOutDetails(String email) {
		List<String> list = new ArrayList<>();
		Employee employee = employeeRepository.findByemail(email);
		Optional<TempSwipeData> tempSwipeData = tempSwipeDataRepository.findById(employee.getEmpid());
		tempSwipeData.get().setTempswipedout(LocalDateTime.now());
		if (tempSwipeData.isPresent()) {
			TempSwipeData tempSwipeData2 = tempSwipeData.get();
			tempSwipeDataRepository.save(tempSwipeData2);
			list.add("updated successfully");
			return new ResponseDto(list, 200);
		}
		list.add("Could not be updated ");
		return new ResponseDto(list, 200);
	}

	// shift ends at 17:00 so
	@Scheduled(cron = "0 0 17 * * *")
	public void updateEntries() {
		LocalDateTime now = LocalDateTime.now();
		SwipeData swipeData = null;
		if(now.getHour()>17) {
			List<TempSwipeData> list= tempSwipeDataRepository.findAll();
			for(TempSwipeData temp:list) {
				swipeData=swipeDataRepository.findByemployee(temp.getEmpid());
				swipeData.setSwipeouttime(temp.getTempswipedout());
				swipeDataRepository.save(swipeData);
			}
		}
	}
	@Scheduled(cron = "0 0 18 * * *")
	  public void deleteTempSwipeData() {
	    tempSwipeDataRepository.deleteAll();
	  }

}
