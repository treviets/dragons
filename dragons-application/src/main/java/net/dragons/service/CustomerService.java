package net.dragons.service;

import java.util.List;

import net.dragons.dto.CustomerDto;
import net.dragons.jpa.entity.Customer;

public interface CustomerService {
	
	List<Customer> getAll();
	
	Customer getById(Long customerId);
	
	List<Customer> getByUsername(String username);
	
	Customer getByUsernameAndPassword(String username, String password);
	
	Long create(CustomerDto customerDto);
	
	void delete(Long customerId);
	
	void update(CustomerDto customerDto);
}
