package net.dragons.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDto {

	@JsonProperty("CustomerId")
	private Integer customerId;
	
	@JsonProperty("HotelId")
	private Integer hotelId;
	
	@JsonProperty("RoomId")
	private Integer roomId;

	@JsonProperty("NumberOfGuess")
	private Integer numberOfGuess;
	
	@JsonProperty("FromDate")
	private Date fromDate;
	
	@JsonProperty("ToDate")
	private Date toDate;

	@JsonProperty("Price")
	private Double price;
	
	@JsonProperty("TotalAmount")
	private Double totalAmount;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getNumberOfGuess() {
		return numberOfGuess;
	}

	public void setNumberOfGuess(Integer numberOfGuess) {
		this.numberOfGuess = numberOfGuess;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
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
	

}
