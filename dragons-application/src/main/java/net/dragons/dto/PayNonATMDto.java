package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.dragons.jpa.entity.City;
import net.dragons.jpa.entity.District;

public class PayNonATMDto {

//	@JsonProperty("MerchantOrderId")
//	private String merchantOrderId;
//	
	@JsonProperty("OrderCode")
	private String orderCode;
	
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

//	public String getMerchantOrderId() {
//		return merchantOrderId;
//	}
//
//	public void setMerchantOrderId(String merchantOrderId) {
//		this.merchantOrderId = merchantOrderId;
//	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
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
