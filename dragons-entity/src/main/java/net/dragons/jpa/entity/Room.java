/**
 * 
 */
package net.dragons.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name="room")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("HomeId")
	@Column(name="home_id")
	private Long homeId;
	
	@JsonProperty("Code")
	@Column(name="code")
	private String code;
	
	@JsonProperty("Price")
	@Column(name="price")
	private String price;
	
	@JsonProperty("NumberOfGuest")
	@Column(name="number_of_guest")
	private Integer numberOfGuest;
	
	@JsonProperty("Description")
	@Column(name="description")
	private String description;
	
	@JsonProperty("RoomType")
	@Column(name="room_type")
	private Integer roomType;
	
	@JsonProperty("RentalType")
	@Column(name="rental_type")
	private Integer rentalType;
	
	@JsonProperty("Bedroom")
	@Column(name="bedroom") 
	private Integer bedroom;
	
	@JsonProperty("Bed")
	@Column(name="bed") 
	private Integer bed;
	
	@JsonProperty("Bath")
	@Column(name="bath") 
	private Integer bath;

	@JsonProperty("Status")
	@Column(name="status")
	private Integer status;
	
	@JsonProperty("Calendar")
	@Column(name="calendar")
	private String calendar;
	
	@JsonProperty("Images")
	@OneToMany(mappedBy="room")
	private List<RoomImage> images = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberOfGuest() {
		return numberOfGuest;
	}

	public void setNumberOfGuest(Integer numberOfGuest) {
		this.numberOfGuest = numberOfGuest;
	}

	public Integer getRoomType() {
		return roomType;
	}

	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}

	public Integer getRentalType() {
		return rentalType;
	}

	public void setRentalType(Integer rentalType) {
		this.rentalType = rentalType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getHomeId() {
		return homeId;
	}

	public void setHomeId(Long homeId) {
		this.homeId = homeId;
	}

	public Integer getBedroom() {
		return bedroom;
	}

	public void setBedroom(Integer bedroom) {
		this.bedroom = bedroom;
	}

	public Integer getBed() {
		return bed;
	}

	public void setBed(Integer bed) {
		this.bed = bed;
	}

	public Integer getBath() {
		return bath;
	}

	public void setBath(Integer bath) {
		this.bath = bath;
	}

	public List<RoomImage> getImages() {
		return images;
	}

	public void setImages(List<RoomImage> images) {
		this.images = images;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}
	
	
}
