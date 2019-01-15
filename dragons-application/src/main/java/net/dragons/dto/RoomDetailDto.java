package net.dragons.dto;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;

import net.dragons.jpa.entity.Amenity;
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

	@JsonProperty("ShortDescription")
	private String shortDescription;
	
	@JsonProperty("LongDescription")
	private String longDescription;
	
	@JsonProperty("Reviews")
	private List<Review> reviews = new ArrayList<>();
	
	@JsonProperty("Images")
	private List<RoomImage> images = new ArrayList<>();
	
	@JsonProperty("Amenities")
	private List<Amenity> amenities = new ArrayList<>();

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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
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
	
	
	
	
}
