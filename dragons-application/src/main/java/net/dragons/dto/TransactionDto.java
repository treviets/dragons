package net.dragons.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDto {
	
	@JsonProperty("CustomerId")
	private int customerId;

	@JsonProperty("CustomerPhone")
	private String customerPhone;
	
	@JsonProperty("CustomerEmail")
	private String customerEmail;
	
	@JsonProperty("TotalAmount")
	private String totalAmount;
	
	@JsonProperty("CreatedAt")
	private Date createdAt;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("ResponseCode")
	private String responseCode;
	
	@JsonProperty("TransactionNumber")
	private String transactionNumber;
	
	@JsonProperty("Status")
	private boolean status;

	@JsonProperty("PaymentType")
	private String paymentType;
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
}
