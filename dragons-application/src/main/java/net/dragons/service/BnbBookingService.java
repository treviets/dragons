package net.dragons.service;

import java.util.Date;
import java.util.List;

import net.dragons.jpa.entity.BnbBooking;

public interface BnbBookingService {

	void deleteAll();
	
	void create(BnbBooking bnb);
	
	void removeBnbBooking(Long roomId, Date from, Date to);
	
	List<Long> findBnbBooking(Long fromDate, Long toDate);
}
