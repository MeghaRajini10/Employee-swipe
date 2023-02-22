package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.entity.SwipeData;

public interface SwipeDataService {


	

//	String getAll(SwipeData swipeData,long empid);

	List<SwipeData> search(long empid);

	

}
