package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.ResponseDto;
import net.dragons.service.HttpService;
import net.dragons.service.OnePayService;

@RestController
@RequestMapping("/payment")
@Api(value = "Payment API Endpoint", description = "Payment Entities Endpoint")
public class PaymentController {

	@RequestMapping(value = "/response/by_atm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto receiveResponseForATM(HttpServletRequest request) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		CompleteATMPaymentRequest responseATM = OnePayService.parseResponse(request);
		boolean isSuccessPayment = OnePayService.validateATMResult(responseATM);
		
		if (isSuccessPayment) {
			// Handle Success
		} else {
			// Handle Error Message
		}

		return responseDto;
	}
	
	@RequestMapping(value = "/by_atm", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto payWithATMCard(@RequestBody PayATMDto payATMDto) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		String urlForATM = OnePayService.buildUrlATM(payATMDto);
		
		try {
			HttpService.requestPayment(urlForATM);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return responseDto;
	}

}
