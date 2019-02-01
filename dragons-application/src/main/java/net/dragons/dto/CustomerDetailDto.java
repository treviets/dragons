package net.dragons.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.EmergencyContact;
import net.dragons.jpa.entity.GuestProfile;
import net.dragons.jpa.entity.Language;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailDto {

	private Customer customer;
	
	private List<EmergencyContact> emergencyContact;
	
	private List<Language> language;
	
	private List<GuestProfile> guestProfile;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<EmergencyContact> getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(List<EmergencyContact> emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public List<GuestProfile> getGuestProfile() {
		return guestProfile;
	}

	public void setGuestProfile(List<GuestProfile> guestProfile) {
		this.guestProfile = guestProfile;
	}

	

}
