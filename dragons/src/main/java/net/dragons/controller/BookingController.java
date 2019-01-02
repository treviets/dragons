package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.BookingDto;
import net.dragons.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	@ResponseBody
	public Object getAllBookings(HttpServletRequest request) throws Exception {
	 	return bookingService.getAll();
	} 
	
	@RequestMapping(value = "/by_hotel_id", method = RequestMethod.GET) 
	@ResponseBody
	public Object getRoomsByHotel(HttpServletRequest request, @RequestParam("hotelId") Long hotelId) throws Exception {
	 	return bookingService.getByHotelId(hotelId);
	} 
	
	@RequestMapping(value = "/by_room_id", method = RequestMethod.GET) 
	@ResponseBody
	public Object getRoomsByRoom(HttpServletRequest request, @RequestParam("roomId") Long roomId) throws Exception {
	 	return bookingService.getByRoomId(roomId);
	} 
	
	@RequestMapping(value = "/by_customer_id", method = RequestMethod.GET) 
	@ResponseBody
	public Object getRoomsByCustomer(HttpServletRequest request, @RequestParam("customerId") Long customerId) throws Exception {
	 	return bookingService.getByCustomerId(customerId);
	} 
	
	@RequestMapping(value = "/create_booking", method = RequestMethod.POST) 
	@ResponseBody
	public Object createNewBooking(HttpServletRequest request, @RequestBody BookingDto bookingDto) throws Exception {
	 	return bookingService.create(bookingDto);
	} 
	
	
	
}
