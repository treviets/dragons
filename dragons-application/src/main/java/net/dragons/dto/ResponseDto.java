package net.dragons.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDto {
	
	@JsonProperty("Status")
	private HttpStatus status;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Data")
	private Object data;
	
	public ResponseDto() {
		
	}
	
	public ResponseDto(HttpStatus status, String message, Object data) {
		this.data = data;
		this.message = message;
		this.status = status;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
}
