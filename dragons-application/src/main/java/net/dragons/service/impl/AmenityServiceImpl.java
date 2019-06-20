package net.dragons.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Amenity;
import net.dragons.repository.AmenityRepository;
import net.dragons.service.AmenityService;

@Service
public class AmenityServiceImpl implements AmenityService{
	
	@Autowired
	AmenityRepository amenityRepository;

	@Override
	public List<Amenity> getAll() {
		List<Amenity> res = new ArrayList<Amenity>();
		try {
			res = amenityRepository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
