package net.dragons.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.dragons.jpa.entity.Transaction;

public class PaymentResponseATM {
	
	@JsonProperty("Url")
	private String redirectUrl;
	
	@JsonProperty("Transaction")
	private Transaction transaction;

	public PaymentResponseATM() {
		
	}
	
	public PaymentResponseATM(String redirectUrl, Transaction transaction) {
		this.redirectUrl = redirectUrl;
		this.transaction = transaction;
	}
	
	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
}
