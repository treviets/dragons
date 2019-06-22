package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayATMDto {

	@JsonProperty("MerchTxnRef")
	private String merchTrxRef;
	
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
	
	public String getMerchTxnRef() {
		return merchTrxRef;
	}

	public void setMerchTxnRef(String merchTrxRef) {
		this.merchTrxRef = merchTrxRef;
	}

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
	
}
