package net.dragons.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.dragons.dto.AdminBookingDto;
import net.dragons.dto.BookingDto;
import net.dragons.jpa.entity.Booking;

public interface BookingService {

	List<Booking> getAll();
	
	List<Booking> getByRoomId(Long hotelId);
	
	List<Booking> getByCustomerId(Long customerId);
	
	Booking create(BookingDto bookingDto);
	
	List<Long> getBookingRoom(Long from, Long to);
	
	List<Integer> getBookedRoom(Long from, Long to);
	
	List<AdminBookingDto> getForAdmin();
	
	Page<Booking> getAll(int pageNumber, int pageSize);

}
