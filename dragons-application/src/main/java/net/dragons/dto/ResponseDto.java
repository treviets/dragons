package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDto {

	@JsonProperty("Data")
	private Object data;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("Status")
	private Integer status;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
}
