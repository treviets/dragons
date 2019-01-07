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
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Customer;
import net.dragons.service.CustomerService;
import util.HttpStatusConstant;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto getAllCustomers(HttpServletRequest request) throws Exception {
		List<Customer> list = new ArrayList<Customer>();
		list = customerService.getAll();

		ResponseDto response = new ResponseDto();
		response.setData(list);
		response.setMessage("OK");
		response.setStatus(HttpStatusConstant.STATUS_OK);
		
		return response;
	} 
	
	@RequestMapping(value = "/by_username", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto getCustomerByUsername(HttpServletRequest request, @RequestParam("user_name") String username) throws Exception {
	 	List<Customer> customers = customerService.getByUsername(username);
	 	
	 	ResponseDto response = new ResponseDto();
		response.setData(customers);
		response.setMessage("OK");
		response.setStatus(HttpStatusConstant.STATUS_OK);
		
		return response;
	} 
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	@ResponseBody
	public ResponseDto createNewCustomer(HttpServletRequest request, @RequestBody CustomerDto customerDto) throws Exception {
		customerService.create(customerDto);
		
		ResponseDto response = new ResponseDto();
		response.setData("");
		response.setMessage("OK");
		response.setStatus(HttpStatusConstant.STATUS_OK);
		
		return response;
	} 
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST) 
	@ResponseBody
	public ResponseDto deleteCustomer(HttpServletRequest request, @RequestParam("customerId") Long customerId) throws Exception {
	 	customerService.delete(customerId);
	 	
	 	return null;
	} 
	
	@RequestMapping(value = "/update", method = RequestMethod.POST) 
	@ResponseBody
	public ResponseDto updateCustomer(HttpServletRequest request, @RequestBody CustomerDto customerDto) throws Exception {
	 	customerService.update(customerDto);
	 	
	 	return null;
	} 
	
}
