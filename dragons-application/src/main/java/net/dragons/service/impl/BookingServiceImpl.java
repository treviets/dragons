package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.dto.BookingDto;
import net.dragons.jpa.entity.Booking;
import net.dragons.repository.BookingRepository;
import net.dragons.service.BookingService;
import util.BookingStatusConstant;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> getByRoomId(Long roomId) {
		return bookingRepository.findByRoomId(roomId);
	}

	@Override
	public List<Booking> getByCustomerId(Long customerId) {
		return bookingRepository.findByCustomerId(customerId);
	}

	@Override
	public Long create(BookingDto bookingDto) {
		Booking booking = new Booking();
		booking.setCustomerId(bookingDto.getCustomerId());
		booking.setFromDate(bookingDto.getFromDate());
		booking.setToDate(bookingDto.getToDate());
		booking.setNumberOfGuess(bookingDto.getNumberOfGuess());
		booking.setPrice(bookingDto.getPrice());
		booking.setRoomId(bookingDto.getRoomId());
		booking.setTotalAmount(bookingDto.getTotalAmount());
		booking.setBookingStatus(BookingStatusConstant.CREATED);
		
		bookingRepository.save(booking);
		
		return booking.getId();
	}
	
	
	

}
