package com.example.employee.dto;

<<<<<<< HEAD
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

=======

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	
	String message;
	
>>>>>>> 377078e53ca8bdd4a98d6b84a83318911bb9f981
}
