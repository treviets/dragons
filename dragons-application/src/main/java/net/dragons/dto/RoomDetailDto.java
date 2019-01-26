package net.dragons.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.dragons.jpa.entity.Accessibility;
import net.dragons.jpa.entity.Amenity;
import net.dragons.jpa.entity.Policy;
import net.dragons.jpa.entity.Review;
import net.dragons.jpa.entity.RoomImage;

public class RoomDetailDto {

	@JsonProperty("Id")
	private Long id;
	
	@JsonProperty("RoomId")
	private Long roomId;

	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Bedroom")
	private Integer bedroom;
	
	@JsonProperty("Bed")
	private Integer bed;
	
	@JsonProperty("Bath")
	private Integer bath;

	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("TheSpace")
	private String the_space;
	
	@JsonProperty("GuestAccess")
	private String guest_access;
	
	@JsonProperty("InteractionWithGuests")
	private String interaction_with_guests;
	
	@JsonProperty("OtherThings")
	private String other_things;
		
	@JsonProperty("GetAround")
	private String get_around;
	
	@JsonProperty("AboutNeighborhood")
	private String about_neighborhood;
	
	@JsonProperty("Reviews")
	private List<Review> reviews = new ArrayList<>();
	
	@JsonProperty("Images")
	private List<RoomImage> images = new ArrayList<>();
	
	@JsonProperty("Amenities")
	private List<Amenity> amenities = new ArrayList<>();
	
	@JsonProperty("Accessibilities")
	private List<Accessibility> accessibilities = new ArrayList<>();

	@JsonProperty("Policies")
	private List<Policy> policies = new ArrayList<>();
	
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

	public List<Amenity> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
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

	public List<Accessibility> getAccessibilities() {
		return accessibilities;
	}

	public void setAccessibilities(List<Accessibility> accessibilities) {
		this.accessibilities = accessibilities;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	
}
