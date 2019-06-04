package net.dragons.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City {
	
	@JsonProperty("Id")
	@Id
	private int id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Status")
	private boolean status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
