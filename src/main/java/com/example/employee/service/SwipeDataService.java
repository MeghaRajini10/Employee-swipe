package com.example.employee.service;

import com.example.employee.dto.ResponseDto;

public interface SwipeDataService {


	ResponseDto updateTempSwipedOutDetails(String email);

	ResponseDto newSwipedData(String email);

}
