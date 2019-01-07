package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	@ResponseBody
	public Object getAllRooms(HttpServletRequest request) throws Exception {
	 	return roomService.getAll();
	} 
	
	
	@RequestMapping(value = "/by_price_range", method = RequestMethod.GET) 
	@ResponseBody
	public Object getRoomsByPriceRange(HttpServletRequest request, @RequestParam("from") Double from,
										@RequestParam("to") Double to) throws Exception {
	 	return roomService.getByPriceRange(from, to);
	} 
	
	
	
}
