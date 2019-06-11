package net.dragons.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@JsonProperty("Id")
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@JsonProperty("CustomerId")
	@Column(name = "customer_id")
	private long customerId;

	@JsonProperty("CustomerPhone")
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@JsonProperty("CustomerEmail")
	@Column(name = "customer_email")
	private String customerEmail;
	
	@JsonProperty("TotalAmount")
	@Column(name = "total_amount")
	private float totalAmount;
	
	@JsonProperty("CreatedAt")
	@Column(name = "created_at")
	private Date createdAt;
	
	@JsonProperty("Message")
	@Column(name = "vcp_message")
	private String message;
	
	@JsonProperty("ResponseCode")
	@Column(name = "vpc_txn_response_code")
	private String responseCode;
	
	@JsonProperty("TransactionNumber")
	@Column(name = "vpc_transaction_no")
	private String transactionNumber;
	
	@JsonProperty("Status")
	@Column(name = "status")
	private String status;

	@JsonProperty("PaymentType")
	@Column(name = "payment_type")
	private String paymentType;
	
	@JsonProperty("AdditionalData")
	@Column(name = "vpc_addition_data")
	private String additionalData;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
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

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
