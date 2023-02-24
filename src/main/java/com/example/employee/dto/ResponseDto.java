package com.example.employee.dto;

import java.util.List;

public class ResponseDto {
	private List<String> messages;
	private int code;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ResponseDto(List<String> messages, int code) {
		super();
		this.messages = messages;
		this.code = code;
	}

}
