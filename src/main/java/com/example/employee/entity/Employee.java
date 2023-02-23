package com.example.employee.entity;


import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int empid;
	public String empName;
	public String email;
	public String contactNumber;
	public String branch;
	public String shift;
	public String role;
	
=======
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
>>>>>>> 377078e53ca8bdd4a98d6b84a83318911bb9f981

}
