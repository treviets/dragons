package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import net.dragons.dto.LoginDto;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.CustomerNewEntity;
import net.dragons.security.TokenAuthenticationService;
import net.dragons.service.CustomerService;
import net.dragons.jpa.entity.security.*;



@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	


	
	@RequestMapping(value = "/account", method = RequestMethod.POST) 
	@ResponseBody
	public Object login(HttpServletRequest request, @RequestBody LoginDto loginDto) throws Exception {
		//check account ton tai
		CustomerNewEntity customerNewEntity = new CustomerNewEntity();
		ResponseDto response = new ResponseDto();

		customerNewEntity = customerService.getByEmail(loginDto.getUsername());
		
		if (customerNewEntity == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("Tài khoản không tồn ");
		}else {
			Boolean check = BCrypt.checkpw(loginDto.getPassword(), customerNewEntity.getPassword());
			System.out.println(check);
			if (!check) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("Mật khẩu không chính xác");
			}else {
				long nowMillis = System.currentTimeMillis();
				String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(customerNewEntity.getId()), String.valueOf(customerNewEntity.getEmail()), String.valueOf(customerNewEntity.getRoleId()), nowMillis);
				response.setStatus(HttpStatus.OK);
				response.setMessage("Success");
				response.setData(token);
			}
		}	 	
		return response;
	} 
}
