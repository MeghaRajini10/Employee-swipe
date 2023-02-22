package com.example.employee.service;

import com.example.employee.dto.ResponseDto;
import com.example.employee.dto.SwipeDataDto;

public interface SwipeDataService {

	ResponseDto newSwipedData(SwipeDataDto swipeDataDto);

	ResponseDto updateTempSwipedOutDetails(String email);

}
