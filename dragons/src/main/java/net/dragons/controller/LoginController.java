package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.CustomerDto;
import net.dragons.dto.ResponseDto;
import net.dragons.dto.ResponseLoginDto;
import net.dragons.jpa.entity.CustomerNewEntity;
import net.dragons.security.TokenAuthenticationService;
import net.dragons.service.CustomerService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	@ResponseBody
	public Object adminLogin(@RequestBody CustomerDto customer) throws Exception {
		ResponseDto response = new ResponseDto();
		
		return response;
		
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestBody CustomerDto customerNewDto) throws Exception {
		// check account ton tai
		CustomerNewEntity customerNewEntity = new CustomerNewEntity();
		ResponseLoginDto loginDto = new ResponseLoginDto();
		
		ResponseDto response = new ResponseDto();
		String email = customerNewDto.getEmail();
		String password = customerNewDto.getPassword();

		customerNewEntity = customerService.getByEmail(email);

		if (customerNewEntity == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessage("The password you entered is incorrect. Try again, or choose another login option.");
		} else {
			Boolean check = BCrypt.checkpw(password, customerNewEntity.getPassword());
			System.out.println(check);
			if (!check) {
				response.setData("");
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage("The password you entered is incorrect. Try again, or choose another login option.");
			} else {
				long nowMillis = System.currentTimeMillis();
				String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(customerNewEntity.getId()),
					String.valueOf(customerNewEntity.getEmail()), String.valueOf(customerNewEntity.getRoleId()),nowMillis);
				
				//get customer info
				CustomerNewEntity cus = customerService.getByEmail(email);
			
				loginDto.setCusId(cus.getId());
				loginDto.setToken(token);
				loginDto.setRole(cus.getRoleId());
				
				response.setStatus(HttpStatus.OK);
				response.setMessage("Success");
				response.setData(loginDto);
			}
		}
		return response;
	}

	// LOGIN BY SOCIAL USER
	@RequestMapping(value = "/social", method = RequestMethod.POST)
	public @ResponseBody ResponseDto signUpBySocial(HttpServletRequest request) throws Exception {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setEmail(request.getParameter("Email"));
		customerDto.setFacebookid(request.getParameter("Facebookid"));
		customerDto.setGoogleid(request.getParameter("Googleid"));
		String userId = request.getParameter("userId");
		if (userId != null && !userId.equals("")) {
			customerDto.setUserId(Integer.parseInt(userId));
		}
		
		
		CustomerNewEntity customerNewEntity = new CustomerNewEntity();
		ResponseDto response = new ResponseDto();
		ResponseLoginDto loginDto = new ResponseLoginDto();
		
		// check account ton tai trong customer
		customerNewEntity = customerService.getByEmail(customerDto.getEmail());
		
		String passFake = "";
		if (customerNewEntity == null) {
			if (customerDto.getGoogleid() != null) {
				passFake = customerDto.getGoogleid() + "tdh";
			}
			if (customerDto.getFacebookid() != null) {
				passFake = customerDto.getFacebookid() + "tdh";
			}
			customerDto.setPassword(BCrypt.hashpw(passFake, BCrypt.gensalt(12)));
			
			int id = customerService.createCustomer(customerDto);
			customerDto.setUserId(id);

			customerService.signUpBySocial(customerDto);

			CustomerNewEntity enti = customerService.getByEmail(customerDto.getEmail());

			long nowMillis = System.currentTimeMillis();
			String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(enti.getId()),
					String.valueOf(enti.getEmail()), String.valueOf(enti.getRoleId()), nowMillis);
			
			loginDto.setToken(token);
			loginDto.setCusId(enti.getId());
			response.setData(loginDto);
			response.setMessage("Success");
			response.setStatus(HttpStatus.OK);
		} else {
			CustomerNewEntity customer = customerService.getByEmail(customerDto.getEmail());

			CustomerNewEntity linkExist = customerService.getByEmail(customerDto.getEmail());
			if (linkExist != null) {
				long nowMillis = System.currentTimeMillis();
				String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(customer.getId()),
						String.valueOf(customer.getEmail()), String.valueOf(customer.getRoleId()), nowMillis);
				
				loginDto.setToken(token);
				loginDto.setCusId(linkExist.getId());
				response.setData(loginDto);
				response.setMessage("Success");
				response.setStatus(HttpStatus.OK);

			} else {
				customerService.signUpBySocial(customerDto);
				long nowMillis = System.currentTimeMillis();
				String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(customer.getId()),
						String.valueOf(customer.getEmail()), String.valueOf(customer.getRoleId()), nowMillis);
				CustomerNewEntity cus = customerService.getByEmail(customerDto.getEmail());
				
				loginDto.setToken(token);
				loginDto.setCusId(cus.getId());
				response.setData(loginDto);
				response.setMessage("Success");
				response.setStatus(HttpStatus.OK);
			}

		}

		return response;
	}

	
}
