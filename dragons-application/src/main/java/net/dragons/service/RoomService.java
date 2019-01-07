package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Room;

public interface RoomService {

	List<Room> getAll();
	
	List<Room> getByPriceRange(double from, double to);
}
