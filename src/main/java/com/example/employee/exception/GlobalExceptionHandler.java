package com.example.employee.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.employee.dto.ResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorDetails = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorDetails.add(error.getDefaultMessage());
		}
		ResponseDto response = new ResponseDto(errorDetails, 400);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(EmployeeNotFoundException ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ResponseDto response = new ResponseDto(errors,500);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SwipedException.class)
	public ResponseEntity<Object> handleUserNotFoundException(SwipedException ex, WebRequest req) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getMessage());
		ResponseDto response = new ResponseDto(errors,500);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}


}
