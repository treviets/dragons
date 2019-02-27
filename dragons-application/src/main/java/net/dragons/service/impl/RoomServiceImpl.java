package net.dragons.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Room;
import net.dragons.repository.RoomRepository;
import net.dragons.service.BookingService;
import net.dragons.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	@Override
	public List<Room> getByFilter(Long homeId, Long fromDate, Long toDate, Integer numberOfGuest,String min, String max, Integer roomtype) {
		// Get List of Room that're booked
		long[] bookings = bookingService.getBookingRoom(fromDate, toDate);
		
		if(bookings.length < 1 || bookings == null) {
			bookings = null;
		}
		// Get List of Room not In booked list
		List<Room> rooms = getRoomsNotBook(bookings, homeId, numberOfGuest, min, max, roomtype);
		
		return rooms;
		
	}

	@Override
	public List<Room> getByHomeId(Long homeId) {
		return roomRepository.findByHomeId(homeId);
	}

	@Override
	public List<Room> getRoomsNotBook(long[] ids, Long homeId, Integer numberOfGuest, String min, String max, Integer roomtype) {
		return roomRepository.findRoomsNotBooked(roomtype,min, max,ids, homeId, numberOfGuest);
	}
	
	

}
