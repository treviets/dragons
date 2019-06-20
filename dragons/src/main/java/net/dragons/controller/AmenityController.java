package net.dragons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Amenity;
import net.dragons.jpa.entity.Room;
import net.dragons.service.AmenityService;

@RestController
@RequestMapping("/amenity")
@Api(value = "amenity API Endpoint", description = "amenity Data Entities Endpoint")
public class AmenityController {
	@Autowired
	private AmenityService amenityService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto getAllAmenity(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();
		try {
			List<Amenity> amenities = amenityService.getAll();
			response.setData(amenities);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}
	
	
	

}
