package com.example.employee.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class SwipeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int swipeid;
	
	private String empname;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empid")
	private Employee employee;
	
	@CreationTimestamp
	private LocalDateTime swipeintime;
	
	private LocalDateTime swipeouttime;
	
	@CreationTimestamp
	private LocalDate date;
	

}
