package net.dragons.service;

import java.util.List;

import net.dragons.dto.CustomerDto;
import net.dragons.dto.CustomerNewDto;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.CustomerNewEntity;
import net.dragons.jpa.entity.SocialLinkAccount;

public interface CustomerService {
	
	List<Customer> getAll();
	
	Customer getById(Long customerId);
	
	List<Customer> getByUsername(String username);
	
	Customer getByUsernameAndPassword(String username, String password);
	
	Long create(CustomerDto customerDto);
	
	void delete(Long customerId);
	
	void update(CustomerDto customerDto);
	
	Long createCustomer(CustomerNewDto customerNewDto);
	
	CustomerNewEntity getByEmail(String email);
	
	ResponseDto updateNewUser(CustomerNewDto customerNewDto);
	
	SocialLinkAccount signUpBySocial(CustomerNewDto customerNewDto);	
	
	
}
