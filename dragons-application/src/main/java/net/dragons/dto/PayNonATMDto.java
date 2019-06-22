package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.dragons.jpa.entity.City;
import net.dragons.jpa.entity.District;

public class PayNonATMDto {

	@JsonProperty("MerchTxnRef")
	private String merchTrxRef;
	
	@JsonProperty("OrderInfor")
	private String orderInfor;
	
	@JsonProperty("TotalAmount")
	private float totalAmount;
	
	@JsonProperty("CustomerPhone")
	private String customerPhone;
	
	@JsonProperty("CustomerEmail")
	private String customerEmail;
	
	@JsonProperty("CustomerId")
	private int customerId;
	
	@JsonProperty("FullTextAddress")
	private String fullTextAddress;
	
	@JsonProperty("City")
	private City city;
	
	@JsonProperty("District")
	private District district;


	public String getMerchTrxRef() {
		return merchTrxRef;
	}

	public void setMerchTrxRef(String merchTrxRef) {
		this.merchTrxRef = merchTrxRef;
	}

	public String getOrderInfor() {
		return orderInfor;
	}

	public void setOrderInfor(String orderInfor) {
		this.orderInfor = orderInfor;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFullTextAddress() {
		return fullTextAddress;
	}

	public void setFullTextAddress(String fullTextAddress) {
		this.fullTextAddress = fullTextAddress;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	
}
