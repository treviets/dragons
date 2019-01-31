package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.GuestProfile;

public interface GuestProfileService {
	
	List<GuestProfile> findByCustomerId(Long customerId);
	
}
