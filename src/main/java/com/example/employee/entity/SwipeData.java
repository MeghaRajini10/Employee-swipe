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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class SwipeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int swipeid;
	
	private String empname;
	
	@NotNull(message = "Email is required field")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Enter a valid Email Id")
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empid")
	private Employee employee;
	
	@NotNull
	@CreationTimestamp
	private LocalDateTime swipeintime;
	
	private LocalDateTime swipeouttime;
	
	@CreationTimestamp
	private LocalDate date;
	

}
