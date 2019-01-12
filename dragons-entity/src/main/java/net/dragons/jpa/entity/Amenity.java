/**
 * 
 */
package net.dragons.jpa.entity;

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
@Table(name="amenities")
@NamedQuery(name="Amenity.findAll", query="SELECT a FROM Amenity a")
public class Amenity {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("Name")
	@Column(name="name") 
	private String name;

	@JsonProperty("Desctiption")
	@Column(name="desctiption") 
	private String desctiption;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return desctiption;
	}

	public void setDescription(String desctiption) {
		this.desctiption = desctiption;
	}

	
	
	
}
