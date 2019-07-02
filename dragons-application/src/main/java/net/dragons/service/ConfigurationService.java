package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Configuration;

public interface ConfigurationService {
	
	List<Configuration> findAll();
}
