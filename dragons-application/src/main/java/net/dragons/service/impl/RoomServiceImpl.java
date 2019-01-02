package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Room;
import net.dragons.repository.RoomRepository;
import net.dragons.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getByHotelId(Integer hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getByPriceRange(double from, double to) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
