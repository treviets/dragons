/**
 * 
 */
package net.dragons.jpa.entity;

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
@Table(name="amenity_category")
@NamedQuery(name="AmenityCategory.findAll", query="SELECT a FROM AmenityCategory a")
public class AmenityCategory {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("Name")
	@Column(name="name") 
	private String name;
	

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



	
	
	
}