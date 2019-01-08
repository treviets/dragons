package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Home;
import net.dragons.repository.HomeRepository;
import net.dragons.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeRepository homeRepository;

	@Override
	public List<Home> getAll() {
		return homeRepository.findAll();
	}
	
	

}
