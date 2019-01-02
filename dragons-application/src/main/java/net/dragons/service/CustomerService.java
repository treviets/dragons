package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Customer;

public interface CustomerService {
	
	List<Customer> getAll();
	
	Customer getById(Long customerId);
	
	List<Customer> getByUsername(String username);
}
