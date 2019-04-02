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
import net.dragons.service.HomeService;
import net.dragons.service.RoomService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private BnbBookingService bnbBookingService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private HomeService hoomService;
	
	@Autowired
	private RoomService roomService;

	@Override
	public List<AdminBookingDto> getBooking() {
		List<AdminBookingDto> result = new ArrayList<AdminBookingDto>();
		
		List<BnbBooking> bnbBookings = bnbBookingService.getAll();
		for (BnbBooking bnbBooking : bnbBookings) {
			AdminBookingDto dto = new AdminBookingDto();
			dto.setFromDate(bnbBooking.getFromDate().toString());
			dto.setToDate(bnbBooking.getToDate().toString());
			dto.setHome(hoomService.findById(bnbBooking.getHomeId()));
			dto.setRoom(roomService.findById(bnbBooking.getRoomId()));
			
			result.add(dto);
		}
		
		
		List<Booking> bookings = bookingService.getAll();
		for (Booking booking : bookings) {
			AdminBookingDto dto = new AdminBookingDto();
			dto.setFromDate(booking.getFromDate().toString());
			dto.setToDate(booking.getToDate().toString());
			dto.setHome(hoomService.findById(booking.getHomeId()));
			dto.setRoom(roomService.findById(booking.getRoomId()));
			
			result.add(dto);
		}
		
		return result;
	}

	
	

}
