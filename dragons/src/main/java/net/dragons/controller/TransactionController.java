package net.dragons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Transaction;
import net.dragons.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto findAllTransaction(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			List<Transaction> list = transactionService.findAll();
			response.setData(list);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}
		
		return response;
	} 
	

	@RequestMapping(value = "/by_customer", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto findByCustomerId(@RequestParam("customerId") long customerId) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			List<Transaction> list = transactionService.findByCustomerId(customerId);
			response.setData(list);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}
		
		return response;
	} 
	
	@RequestMapping(value = "/by_paymnent_type", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto findByPaymentType(@RequestParam("payment_type") String paymentType) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			List<Transaction> list = transactionService.findByPaymentType(paymentType);
			response.setData(list);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}
		
		return response;
	} 
	
	@RequestMapping(value = "/by_status", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto findByPaymentStatus(@RequestParam("status") String status) throws Exception {
		ResponseDto response = new ResponseDto();
		
		try {
			List<Transaction> list = transactionService.findByPaymentStatus(status);
			response.setData(list);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}
		
		return response;
	} 
	
}
