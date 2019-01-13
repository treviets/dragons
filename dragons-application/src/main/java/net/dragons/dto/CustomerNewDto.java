package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerNewDto {

	@JsonProperty("Lastname")
	private String lastname;
	
	@JsonProperty("Firstname")
	private String firstname;
	
	@JsonProperty("Password")
	private String password;
	
	@JsonProperty("DateOfBirth")
	private String dayofbirth;
	
	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("Avatar")
	private String avatar;
	
	

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDayofbirth() {
		return dayofbirth;
	}

	public void setDayofbirth(String dayofbirth) {
		this.dayofbirth = dayofbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
