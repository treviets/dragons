package net.dragons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.repository.CustomerProfileRepository;
import net.dragons.service.CustomerProfileService;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

	@Autowired
	CustomerProfileRepository customerProfileRepository;

	
}
