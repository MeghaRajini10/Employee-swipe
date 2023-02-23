package com.example.employee.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	public int empId;
	
	@NotBlank(message = "Employee Name is required")
	public String empName;

	@Email(message = "Enter a Valid Email address")
	public String email;

	@Pattern(regexp = "[6789][\\d]{9}",message = "Enter a valid indian contact number")
	public String contactNumber;

	public String branch;

	@Pattern(regexp = "^(?:D|N)$", message = "Mention the shift(D/N)")
	public String shift;

	@Pattern(regexp = "^(?:Employee|Admin)$", message = "Specify the role(Employee/Admin)")
	public String role;


}
