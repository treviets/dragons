package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminBookingDto {

	@JsonProperty("HomeId")
	private Long homeId;
	
	@JsonProperty("RoomId")
	private Long roomId;

	@JsonProperty("FromDate")
	private String fromDate;
	
	@JsonProperty("ToDate")
	private String toDate;

	public Long getHomeId() {
		return homeId;
	}

	public void setHomeId(Long homeId) {
		this.homeId = homeId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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
	

}
