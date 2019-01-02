package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Room;

public interface RoomService {

	List<Room> getAll();
	
	List<Room> getByHotelId(Integer hotelId);
	
	List<Room> getByPriceRange(double from, double to);
}
