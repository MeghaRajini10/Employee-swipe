package com.example.employee.exception;

public class AccessDenied extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	public AccessDenied(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
