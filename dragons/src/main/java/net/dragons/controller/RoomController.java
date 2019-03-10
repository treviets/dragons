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

import io.swagger.annotations.Api;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Room;
import net.dragons.service.RoomService;

@RestController
@RequestMapping("/room")
@Api(value = "Room API Endpoint", description = "Room Data Entities Endpoint")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto getAllRooms(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			List<Room> rooms = roomService.getAll();
			response.setData(rooms);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object getRooms(HttpServletRequest request,
			@RequestParam(name = "homeId", required = false) Long homeId,
			@RequestParam(name = "from", required = false) Long from,
			@RequestParam(name = "to", required = false) Long to,
			@RequestParam(name = "min", required = false) String min,
			@RequestParam(name = "max", required = false) String max,
			@RequestParam(name = "roomtype", required = false) Integer roomtype,
			@RequestParam(name = "number_of_guest", required = false) Integer numberOfGuest) throws Exception {
		ResponseDto response = new ResponseDto();
		
		if (from.longValue() == 0) {
			from = null;
		}
		
		if (to.longValue() == 0) {
			to = null;
		}
		
		try {
			List<Room> rooms = roomService.getByFilter(homeId, from, to, numberOfGuest, min, max, roomtype);
			response.setData(rooms);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
			ex.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/by_home_id", method = RequestMethod.GET)
	@ResponseBody
	public Object getRoomsByHomeId(HttpServletRequest request, @RequestParam("homeId") Long homeId) throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			List<Room> rooms = roomService.getByHomeId(homeId);
			response.setData(rooms);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
}
