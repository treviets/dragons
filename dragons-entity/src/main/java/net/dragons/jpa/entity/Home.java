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
@Table(name = "home")
@NamedQuery(name = "Home.findAll", query = "SELECT h FROM Home h")
public class Home {

	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("Name")
	@Column(name="name")
	private String name;
	
	@JsonProperty("NumberOfRooms")
	@Column(name="number_of_rooms")
	private String numberOfRooms;
	
	@JsonProperty("Address")
	@Column(name="address")
	private String address;
	
	@JsonProperty("City")
	@Column(name="city")
	private String city;
	
	@JsonProperty("Status")
	@Column(name="status")
	private String status;
	
	@JsonProperty("Images")
	@OneToMany(mappedBy="home")
	private List<HomeImage> images = new ArrayList<>();

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

	public String getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<HomeImage> getImages() {
		return images;
	}

	public void setImages(List<HomeImage> images) {
		this.images = images;
	}
	
	
}
