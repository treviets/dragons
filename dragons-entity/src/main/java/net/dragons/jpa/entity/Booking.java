/**
 * 
 */
package net.dragons.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name="booking")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("HomeId")
	@Column(name="home_id")
	private Long homeId;
	
	@JsonProperty("RoomId")
	@Column(name="room_id")
	private Long roomId;
	
	@JsonProperty("CustomerId")
	@Column(name="customer_id")
	private Long customerId;
	
	@JsonProperty("Price")
	@Column(name="price")
	private Double price;
	
	@JsonProperty("NumberOfGuess")
	@Column(name="number_of_guess")
	private Integer numberOfGuess;
	
	@JsonProperty("NumberOfNights")
	@Column(name="number_of_night")
	private Double numberOfNights;
	
	@JsonProperty("FromDate")
	@Column(name="from_date")
	private Date fromDate;
	
	@JsonProperty("ToDate")
	@Column(name="to_date")
	private Date toDate;
	
	@JsonProperty("TotalAmount")
	@Column(name="total_amount")
	private Double totalAmount;

	@JsonProperty("BookingStatus")
	@Column(name="booking_status")
	private Integer bookingStatus;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumberOfGuess() {
		return numberOfGuess;
	}

	public void setNumberOfGuess(Integer numberOfGuess) {
		this.numberOfGuess = numberOfGuess;
	}

	public Double getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(Double numberOfNights) {
		this.numberOfNights = numberOfNights;
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

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Integer bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Long getHomeId() {
		return homeId;
	}

	public void setHomeId(Long homeId) {
		this.homeId = homeId;
	}
	
	
	
}
