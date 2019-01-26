package net.dragons.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

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
	
	@JsonProperty("AdditionalRules")
	private String additional_rules;
	
	@JsonProperty("PolicyCancel")
	private String policy_cancel;
	
	@JsonProperty("CheckIn")
	private String check_in;
	
	@JsonProperty("CheckOut")
	private String check_out;
	
	@JsonProperty("HouseRuleDescriptions")
	private String house_rule_descriptions;
	
	@JsonProperty("CleaningFee")
	private String cleaning_fee;
	
	@JsonProperty("ServiceFee")
	private String service_fee;
	
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

	public String getAdditional_rules() {
		return additional_rules;
	}

	public void setAdditional_rules(String additional_rules) {
		this.additional_rules = additional_rules;
	}

	public String getPolicy_cancel() {
		return policy_cancel;
	}

	public void setPolicy_cancel(String policy_cancel) {
		this.policy_cancel = policy_cancel;
	}

	public String getCheck_in() {
		return check_in;
	}

	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getCheck_out() {
		return check_out;
	}

	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}

	public String getHouse_rule_descriptions() {
		return house_rule_descriptions;
	}

	public void setHouse_rule_descriptions(String house_rule_descriptions) {
		this.house_rule_descriptions = house_rule_descriptions;
	}

	public String getCleaning_fee() {
		return cleaning_fee;
	}

	public void setCleaning_fee(String cleaning_fee) {
		this.cleaning_fee = cleaning_fee;
	}

	public String getService_fee() {
		return service_fee;
	}

	public void setService_fee(String service_fee) {
		this.service_fee = service_fee;
	}
	
	
	
	
}
