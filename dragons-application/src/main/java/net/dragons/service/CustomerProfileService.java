package net.dragons.service;

import net.dragons.jpa.entity.CustomerProfile;

public interface CustomerProfileService {
	
	
	CustomerProfile findByCustomerId(Long customerId);
}
