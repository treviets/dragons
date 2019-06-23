package net.dragons.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.dragons.jpa.entity.Room;

public interface RoomService {

	
	Page<Room> getAll(int pageNumber, int pageSize);
	
	
	List<Room> getAll();
	
	List<Room> getByHomeId(Long homeId);
	
	Room findById(Long roomId);
	
	Long create(Room room);

	List<Room> getByFilter(Long homeId, Long from, Long to, Integer numberOfGuest, String min, String max, Integer roomtype);
	
	List<Room> getRoomsNotBook(List<Long> arr, Long homeId, Integer numberOfGuest, String min, String max, Integer roomtype);

	void update(Room room);
	
	List<Room> getForICalendar();
}
