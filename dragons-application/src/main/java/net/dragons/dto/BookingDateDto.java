package net.dragons.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BookingDateDto {

	@JsonProperty("FromDate")
	private Date fromDate;
	
	@JsonProperty("ToDate")
	private Date toDate;

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

	public BookingDateDto(Date fromDate, Date toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	
	
}
