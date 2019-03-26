package net.dragons.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.dto.AdminBookingDto;
import net.dragons.jpa.entity.BnbBooking;
import net.dragons.jpa.entity.Booking;
import net.dragons.service.AdminService;
import net.dragons.service.BnbBookingService;
import net.dragons.service.BookingService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private BnbBookingService bnbBookingService;
	
	@Autowired
	private BookingService bookingService;

	@Override
	public List<AdminBookingDto> getBooking() {
		List<AdminBookingDto> result = new ArrayList<AdminBookingDto>();
		
		List<BnbBooking> bnbBookings = bnbBookingService.getAll();
		for (BnbBooking bnbBooking : bnbBookings) {
			AdminBookingDto dto = new AdminBookingDto();
			dto.setFromDate(bnbBooking.getFromDate().toString());
			dto.setToDate(bnbBooking.getToDate().toString());
			dto.setHomeId(bnbBooking.getHomeId());
			dto.setRoomId(bnbBooking.getRoomId());
			
			result.add(dto);
		}
		
		
		List<Booking> bookings = bookingService.getAll();
		for (Booking booking : bookings) {
			AdminBookingDto dto = new AdminBookingDto();
			dto.setFromDate(booking.getFromDate().toString());
			dto.setToDate(booking.getToDate().toString());
			dto.setHomeId(booking.getHomeId());
			dto.setRoomId(booking.getRoomId());
			
			result.add(dto);
		}
		
		return result;
	}

	
	

}
