package net.dragons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.dto.AdminBookingDto;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Room;
import net.dragons.service.AdminService;
import net.dragons.service.RoomService;

@RestController
@RequestMapping("/admin")
@Api(value = "Admin API Endpoint", description = "Admin Data Entities Endpoint")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoomService roomService;

	@RequestMapping(value = "/booking/all", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllBookings(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			List<AdminBookingDto> result = adminService.getBooking();
			response.setData(result);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	@RequestMapping(value = "/room/all", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllRooms(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			List<Room> result = roomService.getAll();
			response.setData(result);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	@RequestMapping(value = "/room/update", method = RequestMethod.POST)
	@ResponseBody
	public Object getAllRooms(@RequestBody Room room) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			roomService.update(room);;
			response.setData("");
			response.setMessage("Đã cập nhật thông tin phòng");
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	
}