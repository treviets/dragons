package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Configuration;
import net.dragons.repository.ConfigurationRepository;
import net.dragons.service.ConfigurationService;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

	@Autowired
	ConfigurationRepository configurationRepository;
	
	@Override
	public List<Configuration> findAll() {
		return configurationRepository.findAll();
	}
	
	

}
