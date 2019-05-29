package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayATMDto {

	@JsonProperty("merchantOrderId")
	private String merchantOrderId;
	
	@JsonProperty("merchantOrderId")
	private String orderCode;
	
	@JsonProperty("merchantOrderId")
	private float totalAmount;

	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
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
	
	
}
