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
@Table(name="room_detail")
@NamedQuery(name="RoomDetail.findAll", query="SELECT rd FROM RoomDetail rd")
public class RoomDetail {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("RoomId")
	@Column(name="room_id") 
	private Long roomId;

	@JsonProperty("Title")
	@Column(name="title") 
	private String title;
	
	@JsonProperty("Amenity")
	@Column(name="amenity") 
	private String amenity;
	
	@JsonProperty("Bedroom")
	@Column(name="bedroom") 
	private Integer bedroom;
	
	@JsonProperty("Bed")
	@Column(name="bed") 
	private Integer bed;
	
	@JsonProperty("Bath")
	@Column(name="bath") 
	private Integer bath;

	@JsonProperty("Description")
	@Column(name="description") 
	private String description;
	
	@JsonProperty("TheSpace")
	@Column(name="the_space") 
	private String theSpace;
	
	@JsonProperty("GuestAccess")
	@Column(name="guest_access") 
	private String guestAccess;
	
	@JsonProperty("InteractionWithGuests")
	@Column(name="interaction_with_guests") 
	private String interactionWithGuests;
	
	@JsonProperty("OtherThings")
	@Column(name="other_things") 
	private String otherThings;
	
	@JsonProperty("Reviews")
	@OneToMany(mappedBy="roomDetailId")
	private List<Review> reviews = new ArrayList<>();
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTheSpace() {
		return theSpace;
	}

	public void setTheSpace(String theSpace) {
		this.theSpace = theSpace;
	}

	public String getGuestAccess() {
		return guestAccess;
	}

	public void setGuestAccess(String guestAccess) {
		this.guestAccess = guestAccess;
	}

	public String getInteractionWithGuests() {
		return interactionWithGuests;
	}

	public void setInteractionWithGuests(String interactionWithGuests) {
		this.interactionWithGuests = interactionWithGuests;
	}

	public String getOtherThings() {
		return otherThings;
	}

	public void setOtherThings(String otherThings) {
		this.otherThings = otherThings;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	
	
}
