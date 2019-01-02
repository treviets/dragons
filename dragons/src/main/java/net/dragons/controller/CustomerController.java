package net.dragons.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.CustomerDto;
import net.dragons.jpa.entity.Customer;
import net.dragons.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	@ResponseBody
	public Object getAllCustomers(HttpServletRequest request) throws Exception {
		List<Customer> list = new ArrayList<Customer>();
		list = customerService.getAll();

		return list;
	} 
	
	@RequestMapping(value = "/by_username", method = RequestMethod.GET) 
	@ResponseBody
	public Object getCustomerByUsername(HttpServletRequest request, @RequestParam("user_name") String username) throws Exception {
	 	return customerService.getByUsername(username);
	} 
	
	@RequestMapping(value = "/create", method = RequestMethod.GET) 
	@ResponseBody
	public Object createNewCustomer(HttpServletRequest request, @RequestBody CustomerDto customerDto) throws Exception {
	 	return customerService.create(customerDto);
	} 
	
	
}
