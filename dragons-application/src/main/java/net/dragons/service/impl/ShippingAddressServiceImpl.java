package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.ShippingAddress;
import net.dragons.repository.ShippingAddressRepository;
import net.dragons.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

	@Autowired
	ShippingAddressRepository shippingAddressRepository;

	@Override
	public List<ShippingAddress> findByCustomerId(Long customerId) {
		return shippingAddressRepository.findByCustomerId(customerId);
	}

	
	
	

}
