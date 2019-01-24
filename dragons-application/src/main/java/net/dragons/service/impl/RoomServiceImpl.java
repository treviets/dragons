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
	public List<Room> getByFilter(Integer province, Long fromDate, Long toDate, Integer numberOfGuest) {
		// Get List of Room that're booked
		long[] bookings = bookingService.getBookingRoom(fromDate, toDate);
		
		if(bookings.length < 1 || bookings == null) {
			bookings = null;
		}
		// Get List of Room not In booked list
		if (province == 0) {
			province = null;
		}
		List<Room> rooms = getRoomsNotBook(bookings, province, numberOfGuest);
		
		return rooms;
		
	}

	@Override
	public List<Room> getByHomeId(Long homeId) {
		return roomRepository.findByHomeId(homeId);
	}

	@Override
	public List<Room> getRoomsNotBook(long[] ids, Integer province, Integer numberOfGuest) {
		return roomRepository.findRoomsNotBooked(ids, province, numberOfGuest);
	}
	
	

}
