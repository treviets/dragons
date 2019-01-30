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
@Table(name = "shipping_address")
@NamedQuery(name = "ShippingAddress.findAll", query = "SELECT c FROM ShippingAddress c")
public class ShippingAddress {
	
	@JsonProperty("Id")
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "primary_address")
	private String primaryAddress;
	
	@Column(name = "optional_address")
	private String optionalAddress;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "postal_code")
	private String postalCode;

	
	
}
