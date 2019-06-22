package net.dragons.service;

import java.util.List;
import org.springframework.data.domain.Page;

import net.dragons.dto.AdminBookingDto;

public interface AdminService {
	
	List<AdminBookingDto> getBooking ();
	
	Page<AdminBookingDto> getBooking(Integer pageNumber, Integer pageSize);
}
