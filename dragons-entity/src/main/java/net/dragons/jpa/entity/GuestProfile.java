/**
 * 
 */
package net.dragons.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name="guest_profile")
@NamedQuery(name="GuestProfile.findAll", query="SELECT r FROM GuestProfile r")
public class GuestProfile {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("CustomerId")
	@Column(name="customer_id")
	private Long customerId;
	
	@JsonProperty("FirstName")
	@Column(name="first_name")
	private String firstName;
	
	@JsonProperty("LastName")
	@Column(name="last_name")
	private String lastName;
	
	@JsonProperty("PassportNumber")
	@Column(name="passport_number")
	private String passportNumber;
	
	@JsonProperty("Nationality")
	@Column(name="nationality")
	private String nationality;
	
	@JsonProperty("Expires")
	@Column(name="expires")
	private Date expires;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	
}
