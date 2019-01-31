package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.GuestProfile;
import net.dragons.repository.GuestProfileRepository;
import net.dragons.service.GuestProfileService;

@Service
public class GuestProfileServiceImpl implements GuestProfileService {

	@Autowired
	GuestProfileRepository guestProfileRepository;

	@Override
	public List<GuestProfile> findByCustomerId(Long customerId) {
		return guestProfileRepository.findByCustomerId(customerId);
	}

	
}
