package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.ResponseDto;
import com.example.employee.entity.SwipeData;

public interface SwipeDataService {


	ResponseDto updateTempSwipedOutDetails(String email);

	ResponseDto newSwipedData(String email);

	List<SwipeData> searchSwipeData(String email, String fromDate, String toDate);

}
