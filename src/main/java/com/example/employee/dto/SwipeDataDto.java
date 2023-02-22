package com.example.employee.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
public class SwipeDataDto {

	private String empname;

	private String empemail;
	
	@CreationTimestamp
	private LocalDateTime swipeintime;

	private LocalDateTime swipeouttime;
	
	@CreationTimestamp
	private LocalDate date;

}
