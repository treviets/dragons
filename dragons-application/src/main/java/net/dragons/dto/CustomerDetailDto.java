package net.dragons.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.dragons.jpa.entity.Currency;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.EmergencyContact;
import net.dragons.jpa.entity.GuestProfile;
import net.dragons.jpa.entity.Language;
import net.dragons.jpa.entity.SocialLinkAccount;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDetailDto {

	@JsonProperty("Customer")
	private Customer customer;
	
	@JsonProperty("EmergencyContact")
	private List<EmergencyContact> emergencyContact;
	
	@JsonProperty("Language")
	private List<Language> language;
	
	@JsonProperty("Currency")
	private List<Currency> currency;
	
	@JsonProperty("GuestProfile")
	private List<GuestProfile> guestProfile;
	
	@JsonProperty("SocialLinkAccount")
	private SocialLinkAccount socialLinkAccount;

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

	public List<Currency> getCurrency() {
		return currency;
	}

	public void setCurrency(List<Currency> currency) {
		this.currency = currency;
	}

	public SocialLinkAccount getSocialLinkAccount() {
		return socialLinkAccount;
	}

	public void setSocialLinkAccount(SocialLinkAccount socialLinkAccount) {
		this.socialLinkAccount = socialLinkAccount;
	}
	
}
