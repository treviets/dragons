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
import net.dragons.jpa.entity.Home;
import net.dragons.service.HomeService;

@RestController
@RequestMapping("/home")
@Api(value = "Home API Endpoint", description = "Home Data Entities Endpoint")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto getAllHotels(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();
		
		List<Home> homes = homeService.getAll();
		
		response.setData(homes);
		response.setMessage("");
		response.setStatus(HttpStatus.OK);
		
	 	return response;
	}
	
}
