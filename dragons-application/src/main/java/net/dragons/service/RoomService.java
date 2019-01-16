package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Room;

public interface RoomService {

	List<Room> getAll();
	
	List<Room> getByHomeId(Long homeId);
	
	List<Room> getByFilter(Integer city, Long from, Long to, Integer numberOfGuest);
	
	List<Room> getRoomsNotBook(long[] arr, Integer city, Integer numberOfGuest);
}
