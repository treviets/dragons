package net.dragons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Room;
import net.dragons.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto getAllRooms(HttpServletRequest request) throws Exception {
		
		List<Room> rooms = roomService.getAll();
		
		ResponseDto response = new ResponseDto();
		response.setData(rooms);
		response.setStatus(HttpStatus.OK);
		response.setMessage("");
	 	
	 	return response;
	} 
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	@ResponseBody
	public Object getRooms(HttpServletRequest request, @RequestParam(name = "city", required = false) Integer city,
														@RequestParam(name = "from", required = false) Integer from,
														@RequestParam(name = "to", required = false) Integer to,
														@RequestParam(name = "number_of_guest", required = false) Integer numberOfGuest) throws Exception {
		
		
		List<Room> rooms = roomService.getByFilter(city, from, to, numberOfGuest);
		
		ResponseDto response = new ResponseDto();
		response.setData(rooms);
		response.setStatus(HttpStatus.OK);
		response.setMessage("");
		
		
		
		return response;
	} 
	
	
	
}
