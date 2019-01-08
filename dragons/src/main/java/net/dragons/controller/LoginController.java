package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.LoginDto;
import net.dragons.service.AccountService;



@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	@ResponseBody
	public Object createInvoice(HttpServletRequest request, @RequestBody LoginDto loginDto) throws Exception {
	 	System.out.println("Login");
		
		
		return null;
	} 
}
