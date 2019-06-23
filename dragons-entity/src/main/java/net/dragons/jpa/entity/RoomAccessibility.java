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
@Table(name="room_accessibility")
@NamedQuery(name="RoomAccessibility.findAll", query="SELECT a FROM RoomAccessibility a")
public class RoomAccessibility {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("RoomId")
	@Column(name="room_id")
	private Long roomId;
	
	@JsonProperty("AccessibilityId")
	@Column(name="accessibility_id") 
	private Long accessibilityId;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="room_id", insertable=false, updatable=false, nullable=false)
	private RoomDetail roomAccessibility;

	@JsonProperty("Accessibility")
	@OneToOne()
	@JoinColumn(name="accessibility_id", insertable=false, updatable=false, nullable=false)
	private Accessibility accessibility;

	
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

	public Long getAccessibilityId() {
		return accessibilityId;
	}

	public void setAccessibilityId(Long accessibilityId) {
		this.accessibilityId = accessibilityId;
	}

	public RoomDetail getRoomAccessibility() {
		return roomAccessibility;
	}

	public void setRoomAccessibility(RoomDetail roomAccessibility) {
		this.roomAccessibility = roomAccessibility;
	}


	public Accessibility getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(Accessibility accessibility) {
		this.accessibility = accessibility;
	}

	
}
