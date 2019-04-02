package net.dragons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.dragons.jpa.entity.Home;
import net.dragons.jpa.entity.Room;

public class AdminBookingDto {

	@JsonProperty("Home")
	private Home home;
	
	@JsonProperty("Room")
	private Room room;

	@JsonProperty("FromDate")
	private String fromDate;
	
	@JsonProperty("ToDate")
	private String toDate;

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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
