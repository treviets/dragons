package net.dragons.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.BnbBooking;
import net.dragons.jpa.entity.Room;
import net.dragons.repository.RoomRepository;
import net.dragons.service.BnbBookingService;
import net.dragons.service.BookingService;
import net.dragons.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	BnbBookingService bnbBookingService;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	@Override
	public List<Room> getByFilter(Long homeId, Long fromDate, Long toDate, Integer numberOfGuest,String min, String max, Integer roomtype) {
		// Lay danh sach cac phong da duoc book tren trang Airbnb
		List<Long> bnbRooms = bnbBookingService.findBnbBooking(fromDate, toDate);
		
		// Lay danh sach cac phong da duoc book tren trang The dragon host
		long[] bookings = bookingService.getBookingRoom(fromDate, toDate);
		List<Long> ids = Arrays.stream(bookings).boxed().collect(Collectors.toList());
		
		// Append 2 list lai thanh 1 => Danh sach cac phong da duoc book tren ca 2 web site
		List<Long> list = new ArrayList<Long>();
		Stream.of(bnbRooms, ids).forEach(list::addAll);
		
		// Remove duplicate trong list
		List<Long> result = new ArrayList<Long>(new HashSet<>(list));
		
		// Get List of Room not In booked list
		List<Room> rooms = roomRepository.findRoomsNotBooked(roomtype, min, max, result, homeId, numberOfGuest);
		
		return rooms;
		
	}

	@Override
	public List<Room> getByHomeId(Long homeId) {
		return roomRepository.findByHomeId(homeId);
	}

//	@Override
//	public List<Room> getRoomsNotBook(long[] ids, Long homeId, Integer numberOfGuest, String min, String max, Integer roomtype) {
//		return roomRepository.findRoomsNotBooked(roomtype, min, max, ids, homeId, numberOfGuest);
//	}
//	

	@Override
	public List<Room> getRoomsNotBook(List<Long> ids, Long homeId, Integer numberOfGuest, String min, String max, Integer roomtype) {
		return roomRepository.findRoomsNotBooked(roomtype, min, max, ids, homeId, numberOfGuest);
	}
	
	

}
