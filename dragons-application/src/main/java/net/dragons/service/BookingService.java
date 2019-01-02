package net.dragons.service;

import java.util.List;

import net.dragons.dto.BookingDto;
import net.dragons.jpa.entity.Booking;

public interface BookingService {

	List<Booking> getAll();
	
	List<Booking> getByHotelId(Long hotelId);
	
	List<Booking> getByRoomId(Long hotelId);
	
	List<Booking> getByCustomerId(Long customerId);
	
	Long create(BookingDto bookingDto);
}
