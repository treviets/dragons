package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import net.dragons.dto.CustomerNewDto;
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
	public Object login(CustomerNewDto customerNewDto) throws Exception {
		//check account ton tai
		CustomerNewEntity customerNewEntity = new CustomerNewEntity();
		ResponseDto response = new ResponseDto();
		String email = customerNewDto.getEmail();
		String password = customerNewDto.getPassword();

		customerNewEntity = customerService.getByEmail(email);
		
		if (customerNewEntity == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("The password you entered is incorrect. Try again, or choose another login option.");
		}else {
			Boolean check = BCrypt.checkpw(password, customerNewEntity.getPassword());
			System.out.println(check);
			if (!check) {
				response.setData("");
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("The password you entered is incorrect. Try again, or choose another login option.");
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
	// LOGIN BY SOCIAL USER
		@RequestMapping(value = "/social", method = RequestMethod.POST) 
		public @ResponseBody ResponseDto signUpBySocial(CustomerNewDto customerNewDto) throws Exception {
			CustomerNewEntity customerNewEntity = new CustomerNewEntity();
			ResponseDto response = new ResponseDto();
			
			System.out.println(customerNewDto.getGoogleid());
			System.out.println(customerNewDto.getFbid());

			
			//check account ton tai trong customer
			customerNewEntity = customerService.getByEmail(customerNewDto.getEmail());
			String passFake ="";
			if (customerNewEntity == null) {
				if(customerNewDto.getGoogleid() != "") {
					passFake = customerNewDto.getGoogleid() +"tdh";
				}
				if(customerNewDto.getFbid() != null) {
					passFake = customerNewDto.getFbid() +"tdh";
				}
				customerNewDto.setPassword(BCrypt.hashpw(passFake, BCrypt.gensalt(12)));
				int id = customerService.createCustomer(customerNewDto);
				customerNewDto.setUserId(id);
				
				customerService.signUpBySocial(customerNewDto);
				
				//get customer vua duoc tao
				CustomerNewEntity enti = customerService.getByEmail(customerNewDto.getEmail());
				
				long nowMillis = System.currentTimeMillis();
				String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(enti.getId()), String.valueOf(enti.getEmail()), String.valueOf(enti.getRoleId()), nowMillis);
				
				response.setData(token);
				response.setMessage("Success");
				response.setStatus(HttpStatus.OK);
			}else {
				CustomerNewEntity enti = customerService.getByEmail(customerNewDto.getEmail());
				
				//check da ton tai account social
				customerService.getByCustomerId(customerNewDto);
				
				CustomerNewEntity linkExist = customerService.getByEmail(customerNewDto.getEmail());
				if (linkExist != null) {
					long nowMillis = System.currentTimeMillis();
					String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(enti.getId()), String.valueOf(enti.getEmail()), String.valueOf(enti.getRoleId()), nowMillis);
					
					response.setData(token);
					response.setMessage("Success");
					response.setStatus(HttpStatus.OK);
				}else {
					customerService.signUpBySocial(customerNewDto);
					long nowMillis = System.currentTimeMillis();
					String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(enti.getId()), String.valueOf(enti.getEmail()), String.valueOf(enti.getRoleId()), nowMillis);
					
					response.setData(token);
					response.setMessage("Success");
					response.setStatus(HttpStatus.OK);
				}
				
			}
				
			return response;
		} 
}
