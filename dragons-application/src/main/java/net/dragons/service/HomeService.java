package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Home;

public interface HomeService {

	List<Home> getAll();
	
	Home findById(Long homeId);
	
}
