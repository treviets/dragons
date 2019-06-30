package net.dragons.service;

import net.dragons.dto.BookingEmailDto;

public interface EmailService {
	
    public void sendBookingEmail(BookingEmailDto dto);

}
 