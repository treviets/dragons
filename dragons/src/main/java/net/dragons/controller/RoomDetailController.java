package net.dragons.controller;

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
import net.dragons.dto.RoomDetailDto;
import net.dragons.service.RoomDetailService;

@RestController
@RequestMapping("/room_detail")
@Api(value = "Room Detail API Endpoint", description = "Room Detail Data Entities Endpoint")
public class RoomDetailController {

	@Autowired
	private RoomDetailService roomDetailService;

	@RequestMapping(value = "/by_room_id", method = RequestMethod.GET)
	@ResponseBody
	public Object getRoomsByRoomId(HttpServletRequest request, @RequestParam("roomId") Long roomId) throws Exception {
		ResponseDto response = new ResponseDto();

		RoomDetailDto room = roomDetailService.getByRoomId(roomId);
		try {
			response.setData(room);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}

}
