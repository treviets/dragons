package net.dragons.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.dragons.dto.AdminBookingDto;
import net.dragons.dto.BookingDto;
import net.dragons.dto.BookingEmailDto;
import net.dragons.jpa.entity.Booking;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.Transaction;
import net.dragons.repository.BookingRepository;
import net.dragons.repository.CustomerRepository;
import net.dragons.service.BookingService;
import net.dragons.service.EmailService;
import net.dragons.service.TransactionService;
import util.BookingStatusConstant;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	TransactionService transactionService;
	
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
	public Booking create(BookingDto bookingDto) {
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
		booking.setTransactionNumber(bookingDto.getTransactionNumber());
		booking.setCleaningFee(bookingDto.getCleaningFee());
		booking.setServiceFee(bookingDto.getServiceFee());
		
		try {
			bookingRepository.save(booking);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		Optional<Customer> existingCustomer = customerRepository.findById(bookingDto.getCustomerId());
		if (existingCustomer.isPresent()) {
			// Prepare Data
			Customer customer = existingCustomer.get();
			String transactionNumber = bookingDto.getTransactionNumber();
			Transaction transaction = transactionService.findByTransactionNumber(transactionNumber);
			
			BookingEmailDto bookingEmailDto = new BookingEmailDto();
			bookingEmailDto.setBooking(booking);
			bookingEmailDto.setCustomer(customer);
			bookingEmailDto.setTransaction(transaction);
			
			
			emailService.sendBookingEmail(bookingEmailDto);
		}
		return booking;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
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

	@Override
	public Page<Booking> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return bookingRepository.findAll(pageable);
	}
	
	

}
