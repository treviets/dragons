package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.service.ICalendarService;

@RestController
@RequestMapping("/calendar")
@Api(value = "Calendar API Endpoint", description = "Calendar Data Entities Endpoint")
public class ICalendarController {
	
	@Autowired
	private ICalendarService iCalendarService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET) 
	@ResponseBody
	public Object getAllRooms(HttpServletRequest request) throws Exception {
		
		iCalendarService.loadICalendarFile();
	 	
	 	return null;
	} 
	
	
	
	
}
