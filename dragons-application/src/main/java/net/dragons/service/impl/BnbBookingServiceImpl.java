package net.dragons.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.BnbBooking;
import net.dragons.repository.BnbBookingRepository;
import net.dragons.service.BnbBookingService;

@Service
public class BnbBookingServiceImpl implements BnbBookingService {

	@Autowired
	private BnbBookingRepository bnbBookingRepository;

	@Override
	public void create(BnbBooking bnb) {
		bnbBookingRepository.save(bnb);
	}

	@Override
	public void deleteAll() {
		bnbBookingRepository.deleteAll();
	}

	@Override
	public void removeBnbBooking(Long roomId, Date from, Date to) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Long> findBnbBooking(Long fromDate, Long toDate) {
		return bnbBookingRepository.findBnbBooking(fromDate, toDate);
	}

	@Override
	public List<BnbBooking> getAll() {
		return bnbBookingRepository.findAll();
	}
	
	
	

}
