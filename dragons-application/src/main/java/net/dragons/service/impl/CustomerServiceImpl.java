package net.dragons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Customer;
import net.dragons.repository.CustomerRepository;
import net.dragons.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer getById(Long customerId) {
		return customerRepository.findById(customerId);
	}
	
	
}
