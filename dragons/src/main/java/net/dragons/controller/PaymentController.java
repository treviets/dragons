package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;
import net.dragons.dto.ResponseDto;
import net.dragons.jpa.entity.CustomerAddress;
import net.dragons.service.HttpService;
import net.dragons.service.OnePayService;

@RestController
@RequestMapping("/payment")
@Api(value = "Payment API Endpoint", description = "Payment Entities Endpoint")
public class PaymentController {

	@RequestMapping(value = "/by_atm", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto payWithATMCard(@RequestBody PayATMDto payATMDto) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		String urlForATM = OnePayService.buildUrlATM(payATMDto);
		
		try {
			String response = HttpService.requestPayment(urlForATM);
			
			System.out.println(response);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return responseDto;
	}
	
	@RequestMapping(value = "/response/by_atm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto receiveResponseForATM(HttpServletRequest request) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		CompleteATMPaymentRequest responseATM = OnePayService.parseResponse(request);
		boolean isSuccessPayment = OnePayService.validateATMResult(responseATM);
		
		if (isSuccessPayment) {
			responseDto.setData("");
			responseDto.setMessage("");
			responseDto.setStatus(HttpStatus.OK);
		} else {
			responseDto.setData(null);
			responseDto.setMessage("");
			responseDto.setStatus(HttpStatus.BAD_GATEWAY);
		}

		return responseDto;
	}
	
	@RequestMapping(value = "/by_non_atm", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto payWithNonATMCard(@RequestBody PayNonATMDto payNonATMDto, @RequestBody CustomerAddress address) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		String urlForNonATM = OnePayService.buildUrl(payNonATMDto, address);
		
		try {
			HttpService.requestPayment(urlForNonATM);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return responseDto;
	}

}
