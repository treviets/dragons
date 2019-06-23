/**
 * 
 */
package net.dragons.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name="room_amenity")
@NamedQuery(name="RoomAmenity.findAll", query="SELECT a FROM RoomAmenity a")
public class RoomAmenity {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("RoomId")
	@Column(name="room_id")
	private Long roomId;
	
	@JsonProperty("AmenityId")
	@Column(name="amenity_id") 
	private Long amenityId;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="room_id", insertable=false, updatable=false, nullable=false)
	private RoomDetail roomAmenity;
	
	@JsonProperty("Amenity")
	@OneToOne()
	@JoinColumn(name="amenity_id", insertable=false, updatable=false, nullable=false)
	private Amenity amenity;

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

	public Long getAmenityId() {
		return amenityId;
	}

	public void setAmenityId(Long amenityId) {
		this.amenityId = amenityId;
	}

	public RoomDetail getRoomAmenity() {
		return roomAmenity;
	}

	public void setRoomAmenity(RoomDetail roomAmenity) {
		this.roomAmenity = roomAmenity;
	}

	public Amenity getAmenity() {
		return amenity;
	}

	public void setAmenity(Amenity amenity) {
		this.amenity = amenity;
	}
	
	

}
