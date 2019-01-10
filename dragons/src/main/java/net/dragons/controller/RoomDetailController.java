package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.RoomDetail;
import net.dragons.service.RoomDetailService;

@RestController
@RequestMapping("/room_detail")
public class RoomDetailController {
	
	@Autowired
	private RoomDetailService roomDetailService;
	
	@RequestMapping(value = "/by_room_id", method = RequestMethod.GET) 
	@ResponseBody
	public Object getRoomsByRoomId(HttpServletRequest request, @RequestParam("roomId") Long roomId) throws Exception {
		RoomDetail room = roomDetailService.getByRoomId(roomId);
		
		ResponseDto response = new ResponseDto();
		response.setData(room);
		response.setStatus(HttpStatus.OK);
		response.setMessage("");
		
		return response;
	} 
	
	
	
}
