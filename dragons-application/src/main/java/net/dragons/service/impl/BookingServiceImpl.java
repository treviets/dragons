package net.dragons.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.dto.AdminBookingDto;
import net.dragons.dto.BookingDto;
import net.dragons.jpa.entity.Booking;
import net.dragons.jpa.entity.Customer;
import net.dragons.repository.BookingRepository;
import net.dragons.repository.CustomerRepository;
import net.dragons.service.BookingService;
import net.dragons.service.EmailService;
import util.BookingStatusConstant;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmailService emailService;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "yyyy-MM-dd HH:mm:ss");

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> getByRoomId(Long roomId) {
		return bookingRepository.findByRoomId(roomId);
	}

	@Override
	public List<Booking> getByCustomerId(Long customerId) {
		return bookingRepository.findByCustomerId(customerId);
	}

	@Override
	public Long create(BookingDto bookingDto) {
		try {
		Booking booking = new Booking();
		booking.setCustomerId(bookingDto.getCustomerId());
		booking.setHomeId(bookingDto.getHomeId());
		booking.setFromDate(dateFormat.parse(bookingDto.getFromDate()));
		booking.setToDate(dateFormat.parse(bookingDto.getToDate()));
		booking.setNumberOfGuess(bookingDto.getNumberOfGuess());
		booking.setPrice(bookingDto.getPrice());
		booking.setRoomId(bookingDto.getRoomId());
		booking.setTotalAmount(bookingDto.getTotalAmount());
		booking.setNumberOfNights(bookingDto.getNumberOfNights());
		booking.setBookingStatus(BookingStatusConstant.CREATED);
		
		bookingRepository.save(booking);
		
		Optional<Customer> existingCustomer = customerRepository.findById(bookingDto.getCustomerId());
		if (existingCustomer.isPresent()) {
			Customer customer = existingCustomer.get();
			emailService.send("The dragon host booking", "Đã book phòng", customer.getEmail());
		}
		
		
		return booking.getId();
		} catch (ParseException e) {
			e.printStackTrace();
			return (long) 0;
		}
		
	}

	@Override
	public List<Long> getBookingRoom(Long from, Long to) {
		return bookingRepository.findBookingRoom(from, to);
	}
	
	@Override
	public List<Integer> getBookedRoom(Long from, Long to) {
		return bookingRepository.findBookedRoom(from, to);
	}

	@Override
	public List<AdminBookingDto> getForAdmin() {
		
		return null;
	}
	
	

}
