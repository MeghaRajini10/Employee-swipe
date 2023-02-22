package com.example.employee.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class EmployeeDto {

	@NotBlank(message = "Employee Name is required")
	public String empname;

	@Email(message = "Enter a Valid Email address")
	public String empemail;

	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$", message = "Please enter valid Phone Number")
	public String contactnumber;

	public String branch;

	@Pattern(regexp = "^(?:D|N)$", message = "Mention the shift(D/N)")
	public String shift;

	@Pattern(regexp = "^(?:Employee|Admin)$", message = "Specify the role(Employee/Admin)")
	public String role;

}


