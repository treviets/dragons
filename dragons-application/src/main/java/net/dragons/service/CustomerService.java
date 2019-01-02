package net.dragons.service;

import net.dragons.jpa.entity.Customer;

public interface CustomerService {

	Customer getById(Long customerId);
	
}
