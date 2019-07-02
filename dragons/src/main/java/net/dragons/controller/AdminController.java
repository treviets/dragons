package net.dragons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.constant.TheDragonHostConstant;
import net.dragons.dto.ResponseDto;
import net.dragons.dto.RoomDetailDto;
import net.dragons.dto.RoomImageDto;
import net.dragons.jpa.entity.Booking;
import net.dragons.jpa.entity.Room;
import net.dragons.jpa.entity.RoomDetail;
import net.dragons.service.BookingService;
import net.dragons.service.EmailService;
import net.dragons.service.RoomDetailService;
import net.dragons.service.RoomImageService;
import net.dragons.service.RoomService;

@RestController
@RequestMapping("/admin")
@Api(value = "Admin API Endpoint", description = "Admin Data Entities Endpoint")
public class AdminController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private RoomService roomService;	

	@Autowired
	private RoomDetailService roomDetailService;
	
	@Autowired
	private RoomImageService roomImageService;

	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/booking/all/{page}", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllBookings(@PathVariable Integer page) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			Page<Booking> result = bookingService.getAll(page, TheDragonHostConstant.PAGE_SIZE);
			response.setData(result);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	@RequestMapping(value = "/room/all/{page}", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllRooms(@PathVariable Integer page) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			Page<Room> result = roomService.getAll(page, TheDragonHostConstant.PAGE_SIZE);
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
	
	@RequestMapping(value = "/room/create", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseDto addRoom(@RequestBody Room dto) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			Long roomId = roomService.create(dto);
			response.setData(roomId);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	@RequestMapping(value = "/room_detail/create", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseDto addRoomDetail(@RequestBody RoomDetailDto dto) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			RoomDetail roomDetail = roomDetailService.create(dto);
			
			response.setData(roomDetail);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	
	@RequestMapping(value = "/room_image/add", method = RequestMethod.POST)
	@ResponseBody
	public Object addImageForRoom(@RequestBody RoomImageDto roomImages) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			roomImageService.createList(roomImages);
			response.setData("");
			response.setMessage("Da them hinh");
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}
		
		return response;
	}
	
	@RequestMapping(value = "/send_email", method = RequestMethod.POST)
	@ResponseBody
	public Object sendEmail() throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			emailService.sendBookingEmail(null);
			response.setData("");
			response.setMessage("Da them hinh");
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}
		
		return response;
	} 
}
