package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDto {

	@JsonProperty("CustomerId")
	private Long customerId;
	
	@JsonProperty("HomeId")
	private Long homeId;
	
	@JsonProperty("RoomId")
	private Long roomId;

	@JsonProperty("NumberOfGuess")
	private Integer numberOfGuess;
	
	@JsonProperty("NumberOfNights")
	private double numberOfNights;
	
	@JsonProperty("FromDate")
	private String fromDate;
	
	@JsonProperty("ToDate")
	private String toDate;

	@JsonProperty("Price")
	private Double price;
	
	@JsonProperty("TotalAmount")
	private Double totalAmount;
	
	@JsonProperty("TransactionNumber")
	private String transactionNumber;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getHomeId() {
		return homeId;
	}

	public void setHomeId(Long hotelId) {
		this.homeId = hotelId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Integer getNumberOfGuess() {
		return numberOfGuess;
	}

	public void setNumberOfGuess(Integer numberOfGuess) {
		this.numberOfGuess = numberOfGuess;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(double numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

}
