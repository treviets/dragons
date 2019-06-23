package net.dragons.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	public Page<Room> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return roomRepository.findAll(pageable);
	}
	
	@Override
	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	@Override
	public List<Room> getByFilter(Long homeId, Long fromDate, Long toDate, Integer numberOfGuest,String min, String max, Integer roomtype) {
		// Lay danh sach cac phong da duoc book tren trang Airbnb
		List<Long> bnbRooms = new ArrayList<Long>();
		if (fromDate != null && toDate != null) {
			bnbRooms = bnbBookingService.findBnbBooking(fromDate, toDate);
		}
				
		// Lay danh sach cac phong da duoc book tren trang The dragon host
		List<Long> tdhRooms = new ArrayList<Long>();
		if (fromDate != null && toDate != null) {
			tdhRooms = bookingService.getBookingRoom(fromDate, toDate);
		}

		// Append 2 list lai thanh 1 => Danh sach cac phong da duoc book tren ca 2 web site
		List<Long> list = new ArrayList<Long>();
		Stream.of(bnbRooms, tdhRooms).forEach(list::addAll);
		
		// Remove duplicate trong list
		List<Long> result = new ArrayList<Long>(new HashSet<>(list));
		if (result.size() == 0) {
			result.add(Long.valueOf(0));
		}
		
		// Get List of Room not In booked list
		List<Room> rooms = roomRepository.findRoomsNotBooked(roomtype, min, max, result, homeId, numberOfGuest);
		
		return rooms;
		
	}

	@Override
	public List<Room> getByHomeId(Long homeId) {
		if (homeId != null && homeId.longValue() != 0) {
			return roomRepository.findByHomeId(homeId);
		}
		
		return roomRepository.findAll();
	}

	@Override
	public List<Room> getRoomsNotBook(List<Long> ids, Long homeId, Integer numberOfGuest, String min, String max, Integer roomtype) {
		return roomRepository.findRoomsNotBooked(roomtype, min, max, ids, homeId, numberOfGuest);
	}

	@Override
	public void update(Room room) {
		Room r = roomRepository.findById(room.getId());
		
		r.setBath(room.getBath());
		r.setBed(room.getBed());
		r.setBedroom(room.getBedroom());
		r.setCalendar(room.getCalendar());
		r.setPrice(room.getPrice());
		r.setNumberOfGuest(room.getNumberOfGuest());
		r.setCode(room.getCode());
		
		roomRepository.save(r);
	}

	@Override
	public Room findById(Long roomId) {
		return roomRepository.findById(roomId);
	}

	@Override
	public Long create(Room room) {
		Room r = new Room();
		try {
			r = roomRepository.save(room);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return r.getId();
		
	}

	@Override
	public List<Room> getForICalendar() {
		return roomRepository.findRoomByCalendar();
	}
	
	

}
