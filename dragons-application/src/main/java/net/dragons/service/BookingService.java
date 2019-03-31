package net.dragons.service;

import java.util.List;

import net.dragons.dto.AdminBookingDto;
import net.dragons.dto.BookingDto;
import net.dragons.jpa.entity.Booking;

public interface BookingService {

	List<Booking> getAll();
	
	List<Booking> getByRoomId(Long hotelId);
	
	List<Booking> getByCustomerId(Long customerId);
	
	Long create(BookingDto bookingDto);
	
	List<Long> getBookingRoom(Long from, Long to);
	
	List<Integer> getBookedRoom(Long from, Long to);
	
	List<AdminBookingDto> getForAdmin();

}
