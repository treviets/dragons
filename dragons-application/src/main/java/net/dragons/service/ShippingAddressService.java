package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.ShippingAddress;

public interface ShippingAddressService {
	
	List<ShippingAddress> findByCustomerId(Long customerId);
	
}
