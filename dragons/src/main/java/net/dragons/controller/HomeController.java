package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET) 
	@ResponseBody
	public Object getAllHotels(HttpServletRequest request) throws Exception {
	 	return homeService.getAll();
	} 
	
}
