package net.dragons.service;

import java.util.List;

import net.dragons.dto.AdminBookingDto;

public interface AdminService {
	
	List<AdminBookingDto> getBooking ();
}
