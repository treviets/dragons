package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Booking;

public interface BookingService {

	List<Booking> getAll();
	
	List<Booking> getByHotelId(Integer hotelId);
	
	List<Booking> getByRoomId(Integer hotelId);
	
	List<Booking> getByCustomerId(Integer customerId);
}
