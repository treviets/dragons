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

	@JsonProperty("description")
	@Column(name="description") 
	private String description;
	
	@JsonProperty("TheSpace")
	@Column(name="the_space") 
	private String the_space;
	
	@JsonProperty("GuestAccess")
	@Column(name="guest_access") 
	private String guest_access;
	
	@JsonProperty("InteractionWithGuests")
	@Column(name="interaction_with_guests") 
	private String interaction_with_guests;
	
	@JsonProperty("OtherThings")
	@Column(name="other_things") 
	private String other_things;
	
	@JsonProperty("GetAround")
	@Column(name="get_around") 
	private String get_around;
	
	@JsonProperty("AboutNeighborhood")
	@Column(name="about_neighborhood") 
	private String about_neighborhood;
	
	@JsonProperty("Accessibility")
	@Column(name="accessibility") 
	private String accessibility;
	
	@JsonProperty("Reviews")
	@OneToMany(mappedBy="roomDetailId")
	private List<Review> reviews = new ArrayList<>();
	
	@JsonProperty("Images")
	@OneToMany(mappedBy="roomDetail")
	private List<RoomImage> images = new ArrayList<>();

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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<RoomImage> getImages() {
		return images;
	}

	public void setImages(List<RoomImage> images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThe_space() {
		return the_space;
	}

	public void setThe_space(String the_space) {
		this.the_space = the_space;
	}

	public String getGuest_access() {
		return guest_access;
	}

	public void setGuest_access(String guest_access) {
		this.guest_access = guest_access;
	}

	public String getInteraction_with_guests() {
		return interaction_with_guests;
	}

	public void setInteraction_with_guests(String interaction_with_guests) {
		this.interaction_with_guests = interaction_with_guests;
	}

	public String getOther_things() {
		return other_things;
	}

	public void setOther_things(String other_things) {
		this.other_things = other_things;
	}

	public String getGet_around() {
		return get_around;
	}

	public void setGet_around(String get_around) {
		this.get_around = get_around;
	}

	public String getAbout_neighborhood() {
		return about_neighborhood;
	}

	public void setAbout_neighborhood(String about_neighborhood) {
		this.about_neighborhood = about_neighborhood;
	}

	public String getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}
	
	
	
	
	
	

	
	
}
