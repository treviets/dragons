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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author NhanNguyen
 *
 */
@Entity
@Table(name="review")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="room_detail_id", insertable=false, updatable=false, nullable=false)
	private RoomDetail roomDetailId;

	@JsonProperty("Content")
	@Column(name="content") 
	private String content;
	
	@JsonProperty("CreatedAt")
	@Column(name="created_at") 
	private String createdAt;
	
	@JsonProperty("Customer")
	@ManyToOne()
	@JoinColumn(name="customer_id", insertable=false, updatable=false, nullable=false)
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoomDetail getRoomDetailId() {
		return roomDetailId;
	}

	public void setRoomDetailId(RoomDetail roomDetailId) {
		this.roomDetailId = roomDetailId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
