package com.example.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private long empid;
	private String empname;
	private String empemail;
	private String contactnumber;
	private String branch;
	private String shift;
	private String role;

}
