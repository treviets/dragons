package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Booking;
import net.dragons.repository.BookingRepository;
import net.dragons.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> getByHotelId(Integer hotelId) {
		return bookingRepository.findByHotelId(hotelId);
	}

	@Override
	public List<Booking> getByRoomId(Integer roomId) {
		return bookingRepository.findByRoomId(roomId);
	}

	@Override
	public List<Booking> getByCustomerId(Integer customerId) {
		return bookingRepository.findByCustomerId(customerId);
	}
	
	
	

}
