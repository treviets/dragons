package net.dragons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.common.util.Utils;
import net.dragons.dto.CustomerDetailDto;
import net.dragons.dto.CustomerDto;
import net.dragons.dto.ResponseDto;
import net.dragons.dto.ResponseLoginDto;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.CustomerNewEntity;
import net.dragons.security.TokenAuthenticationService;
import net.dragons.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto getAllCustomers(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			List<Customer> list = customerService.getAll();
			response.setData(list);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}

		return response;
	}

	@RequestMapping(value = "/by_username", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto getCustomerByUsername(HttpServletRequest request, @RequestParam("user_name") String username)
			throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			List<Customer> customers = customerService.getByUsername(username);
			response.setData(customers);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}

		return response;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto createNewCustomer(HttpServletRequest request, @RequestBody CustomerDto customerDto)
			throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			customerService.create(customerDto);
			response.setData("");
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}

		return response;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto deleteCustomer(HttpServletRequest request, @RequestParam("customerId") Long customerId)
			throws Exception {
		customerService.delete(customerId);

		return null;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto updateCustomer(HttpServletRequest request, @RequestBody CustomerDto customerDto)
			throws Exception {
		customerService.update(customerDto);

		return null;
	}

	// NEW API FOR CREATE USER
	@RequestMapping(value = "/create_user", method = RequestMethod.POST)
	public @ResponseBody ResponseDto createNewUser(CustomerDto customerNewDto) throws Exception {
		CustomerNewEntity customerNewEntity = new CustomerNewEntity();
		ResponseDto response = new ResponseDto();
		ResponseLoginDto loginDto = new ResponseLoginDto();

		if (!Utils.validateEmail(customerNewDto.getEmail())) {
			response.setData("");
			response.setMessage("Email invalid ");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return response;
		}

		// check account ton tai
		customerNewEntity = customerService.getByEmail(customerNewDto.getEmail());

		if (customerNewEntity == null) {
			String pass = BCrypt.hashpw(customerNewDto.getPassword(), BCrypt.gensalt(12));
			customerNewDto.setPassword(pass);
			customerService.createCustomer(customerNewDto);
			CustomerNewEntity cus = customerService.getByEmail(customerNewDto.getEmail());
			
			long nowMillis = System.currentTimeMillis();
			String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(cus.getId()),
				String.valueOf(cus.getEmail()), String.valueOf(cus.getRoleId()),nowMillis);
			
			
			loginDto.setCusId(cus.getId());
			loginDto.setToken(token);
			response.setData(loginDto);
			response.setMessage("Success");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setData("");
			response.setMessage("Email existed!");
			response.setStatus(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/update_user/", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseDto updateNewUser(@RequestBody CustomerDto customerNewDto) throws Exception {
		ResponseDto response = customerService.updateNewUser(customerNewDto);
		return response;
	}

	// SIGN UP BY SOCIAL USER
	@RequestMapping(value = "/sign_up_user", method = RequestMethod.POST)
	public @ResponseBody ResponseDto signUpBySocial(CustomerDto customerNewDto) throws Exception {
		CustomerNewEntity customerNewEntity = new CustomerNewEntity();
		ResponseDto response = new ResponseDto();

		System.out.println(customerNewDto.getGoogleid());
		System.out.println(customerNewDto.getFbid());

		// check account ton tai trong customer
		customerNewEntity = customerService.getByEmail(customerNewDto.getEmail());
		String passFake = "";
		if (customerNewEntity == null) {
			if (customerNewDto.getGoogleid() != "") {
				passFake = customerNewDto.getGoogleid() + "tdh";
			}
			if (customerNewDto.getFbid() != null) {
				passFake = customerNewDto.getFbid() + "tdh";
			}
			customerNewDto.setPassword(BCrypt.hashpw(passFake, BCrypt.gensalt(12)));
			int id = customerService.createCustomer(customerNewDto);
			customerNewDto.setUserId(id);

			customerService.signUpBySocial(customerNewDto);

			// get customer vua duoc tao
			CustomerNewEntity enti = customerService.getByEmail(customerNewDto.getEmail());

			long nowMillis = System.currentTimeMillis();
			String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(enti.getId()),
					String.valueOf(enti.getEmail()), String.valueOf(enti.getRoleId()), nowMillis);

			response.setData(token);
			response.setMessage("Success");
			response.setStatus(HttpStatus.OK);
		} else {
			CustomerNewEntity enti = customerService.getByEmail(customerNewDto.getEmail());

			// check da ton tai account social
			customerService.getByCustomerId(customerNewDto);

			CustomerNewEntity linkExist = customerService.getByEmail(customerNewDto.getEmail());
			if (linkExist != null) {
				long nowMillis = System.currentTimeMillis();
				String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(enti.getId()),
						String.valueOf(enti.getEmail()), String.valueOf(enti.getRoleId()), nowMillis);

				response.setData(token);
				response.setMessage("Success");
				response.setStatus(HttpStatus.OK);
			} else {
				customerService.signUpBySocial(customerNewDto);
				long nowMillis = System.currentTimeMillis();
				String token = TokenAuthenticationService.createJWTSecurity(String.valueOf(enti.getId()),
						String.valueOf(enti.getEmail()), String.valueOf(enti.getRoleId()), nowMillis);

				response.setData(token);
				response.setMessage("Success");
				response.setStatus(HttpStatus.OK);
			}

		}

		return response;
	}

	@RequestMapping(value = "/detail/by_id", method = { RequestMethod.GET })
	@ResponseBody
	public ResponseDto getCustomerDetail(@RequestParam("customer_id") Long customerId) throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			CustomerDetailDto customerDetail = customerService.getCustomerDetail(customerId);
			response.setData(customerDetail);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}

		return response;
	}

	@RequestMapping(value = "/detail/update", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseDto updateCustomerDetail(@RequestBody CustomerDetailDto dto) throws Exception {
		ResponseDto response = new ResponseDto();

		try {
			customerService.updateCustomerDetail(dto);
			response.setStatus(HttpStatus.OK);
			response.setData("");
		} catch (Exception ex) {
			response.setStatus(HttpStatus.BAD_GATEWAY);
			response.setMessage(ex.toString());
		}

		return response;
	}

}
