package com.example.employee.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Valid
public class EmployeeDto {

	@NotBlank(message = "Employee Name is required")
	public String empname;

	@Email(message = "Enter a Valid Email address")
	public String empemail;

	@Pattern(regexp = "[6789][\\d]{9}",message = "Enter a valid indian contact number")
	public String contactnumber;

	public String branch;

	@Pattern(regexp = "^(?:D|N)$", message = "Mention the shift(D/N)")
	public String shift;

	@Pattern(regexp = "^(?:Employee|Admin)$", message = "Specify the role(Employee/Admin)")
	public String role;

}


