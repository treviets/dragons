package net.dragons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.Currency;
import net.dragons.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET) 
	@ResponseBody
	public ResponseDto getAllCurrencies(HttpServletRequest request) throws Exception {
		ResponseDto response = new ResponseDto();
		List<Currency> list = currencyService.findAll();
		
		try {
			response.setData(list);
			response.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			response.setMessage(ex.toString());
			response.setStatus(HttpStatus.BAD_GATEWAY);
		}
		
		return response;
	} 
	
	
}
