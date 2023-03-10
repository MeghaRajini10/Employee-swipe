package com.example.employee.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TempSwipeData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tempswipeid;
	private LocalDateTime tempswipedout;
	private int empid;
	
	private String email;
}
