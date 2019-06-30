package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.dto.BookingDto;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Booking;
import net.dragons.jpa.entity.Transaction;
import net.dragons.service.BookingService;
import net.dragons.service.TransactionService;

@RestController
@RequestMapping("/booking")
@Api(value = "Booking API Endpoint", description = "Booking Data Entities Endpoint")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllBookings(HttpServletRequest request) throws Exception {
		return bookingService.getAll();
	}

	@RequestMapping(value = "/by_room_id", method = RequestMethod.GET)
	@ResponseBody
	public Object getRoomsByRoom(@RequestParam("roomId") Long roomId) throws Exception {
		return bookingService.getByRoomId(roomId);
	}

	@RequestMapping(value = "/by_customer_id", method = RequestMethod.GET)
	@ResponseBody
	public Object getRoomsByCustomer(@RequestParam("customerId") Long customerId) throws Exception {
		return bookingService.getByCustomerId(customerId);
	}

	@RequestMapping(value = "/create_booking", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object createNewBooking(@RequestBody BookingDto bookingDto) throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			Booking booking = bookingService.create(bookingDto);
			response.setData(booking);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}

		return response;
	}

	@RequestMapping(value = "/get_booking/by_room/", method = RequestMethod.GET)
	@ResponseBody
	public Object getBookingByRoom(HttpServletRequest request, @RequestParam("roomId") Long roomId) throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			response.setData("");
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	
}
