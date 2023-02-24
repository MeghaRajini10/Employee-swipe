package com.example.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	public int empId;

	public String empName;

	public String email;

	public String contactNumber;

	public String branch;

	public String shift;

	public String role;

}