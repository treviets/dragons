package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDto {
	
	@JsonProperty("CustomerId")
	private Long customerId;

	@JsonProperty("Username")
	private String username;
	
	@JsonProperty("Password")
	private String password;
	
	@JsonProperty("ConfirmPassword")
	private String confirmPassword;
	
	@JsonProperty("Email")
	private String email;

	@JsonProperty("Phone")
	private String phone;
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
