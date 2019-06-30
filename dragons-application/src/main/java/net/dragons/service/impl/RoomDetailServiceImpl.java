package net.dragons.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.dto.BookingDateDto;
import net.dragons.dto.RoomDetailDto;
import net.dragons.jpa.entity.BnbBooking;
import net.dragons.jpa.entity.Booking;
import net.dragons.jpa.entity.Room;
import net.dragons.jpa.entity.RoomDetail;
import net.dragons.repository.AccessibilityRepository;
import net.dragons.repository.AmenityRepository;
import net.dragons.repository.BnbBookingRepository;
import net.dragons.repository.BookingRepository;
import net.dragons.repository.PolicyRepository;
import net.dragons.repository.RoomDetailRepository;
import net.dragons.repository.RoomRepository;
import net.dragons.service.RoomDetailService;

@Service
public class RoomDetailServiceImpl implements RoomDetailService {

	@Autowired
	RoomDetailRepository roomDetailRepository;
	
	@Autowired
	RoomRepository roomRepository;

	@Autowired
	AmenityRepository amenityRepository;

	@Autowired
	AccessibilityRepository accessibilityRepository;

	@Autowired
	PolicyRepository policyRepository;

	@Autowired
	EntityManager entityManager;
	
	@Autowired 
	BookingRepository bookingRepository;
	
	@Autowired 
	BnbBookingRepository bnbBookingRepository;
	

	@Override
	public List<RoomDetail> getAll() {
		return roomDetailRepository.findAll();
	}

	ModelMapper mapper;

	@PostConstruct
	public void initialize() {
		mapper = new ModelMapper();
	}

	@Override
	public RoomDetailDto getByRoomId(Long roomId) {
		if (roomId == 0) {
			return null;
		}
		
		RoomDetail detail = roomDetailRepository.findByRoomId(roomId);
		if (detail == null) {
			return null;
		}
		
		RoomDetailDto roomDetailDto = mapper.map(detail, RoomDetailDto.class);
		
		Room room = roomRepository.findById(roomId);
		if (room != null) {
			roomDetailDto.setRoom(room);
		}

		
		List<BookingDateDto> bookingDates = new ArrayList<BookingDateDto>();
		
		// Get booked date from Airbnb
		List<BnbBooking> bnbBookings = bnbBookingRepository.findByRoomId(roomId);
		for (BnbBooking bnbBooknig : bnbBookings) {
			bookingDates.add(new BookingDateDto(bnbBooknig.getFromDate(), bnbBooknig.getToDate()));
		}
		
		// Get booked date from thedragonshost
		List<Booking> bookings = bookingRepository.findByRoomId(roomId);
		for (Booking booking : bookings) {
			bookingDates.add(new BookingDateDto(booking.getFromDate(), booking.getToDate()));
		}
		
		roomDetailDto.setBookingDates(bookingDates);
		
		return roomDetailDto;
	}

	@Override
	public RoomDetail create(RoomDetailDto dto) {
		
		
		return null;
	}

}
