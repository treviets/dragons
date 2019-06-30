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
@Table(name="room_policy")
@NamedQuery(name="RoomPolicy.findAll", query="SELECT a FROM RoomPolicy a")
public class RoomPolicy {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("RoomId")
	@Column(name="room_id")
	private Long roomId;
	
	@JsonProperty("PolicyId")
	@Column(name="policy_id") 
	private Long policyId;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="room_id", insertable=false, updatable=false, nullable=false)
	private RoomDetail roomPolicy;
	
	@JsonProperty("Policy")
	@OneToOne()
	@JoinColumn(name="policy_id", insertable=false, updatable=false, nullable=false)
	private Policy policy;

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

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public RoomDetail getRoomPolicy() {
		return roomPolicy;
	}

	public void setRoomPolicy(RoomDetail roomPolicy) {
		this.roomPolicy = roomPolicy;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	
	
}
