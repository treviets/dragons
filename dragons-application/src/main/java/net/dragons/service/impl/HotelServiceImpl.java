package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Hotel;
import net.dragons.repository.HotelRepository;
import net.dragons.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Hotel> getAll() {
		
		return null;
	}
	
	

}
