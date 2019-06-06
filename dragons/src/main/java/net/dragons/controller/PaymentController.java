package net.dragons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.constant.CompletePaymentRequest;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;
import net.dragons.dto.ResponseDto;
import net.dragons.service.OnePayService;
import net.dragons.service.TransactionService;

@RestController
@RequestMapping("/payment")
@Api(value = "Payment API Endpoint", description = "Payment Entities Endpoint")
public class PaymentController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "/pay_with_atm", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto payWithATMCard(@RequestBody PayATMDto payATMDto) throws Exception {
		ResponseDto responseDto = new ResponseDto();
		
		try {
			// Return URL for Front end
			String urlForATM = OnePayService.buildUrlATM(payATMDto);	
			
			// Create new record in database
			transactionService.createTransactionATM(payATMDto);
			
			responseDto.setData(urlForATM);
			responseDto.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			responseDto.setMessage(ex.getMessage());
			responseDto.setStatus(HttpStatus.BAD_GATEWAY);
		}

		return responseDto;
	}
	
	@RequestMapping(value = "/response/pay_with_atm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto receiveResponseForATM(HttpServletRequest request) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		try {
			// Receive response of OnePay
			CompleteATMPaymentRequest responseATM = OnePayService.parseResponseATM(request);
			
			// Update result of payment
			transactionService.updateTransactionATM(responseATM);
			
			if (!responseATM.getVpcTxnResponseCode().equals("0")) {
				responseDto.setMessage("THANH TOAN THAT BAI");
				responseDto.setStatus(HttpStatus.BAD_GATEWAY);
				
				return responseDto;
			}
			
			boolean isSuccessPayment = OnePayService.validateATMResult(responseATM);
			
			if (isSuccessPayment) {
				responseDto.setMessage("THANH TOAN THANH CONG");
				responseDto.setStatus(HttpStatus.OK);
			} else {
				responseDto.setMessage("THANH TOAN THAT BAI");
				responseDto.setStatus(HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception ex) {
			
		}
		

		return responseDto;
	}
	
	@RequestMapping(value = "/pay_with_non_atm", method = RequestMethod.POST)
	@ResponseBody
	public ResponseDto payWithNonATMCard(@RequestBody PayNonATMDto payNonATMDto) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		try {
			String urlForNonATM = OnePayService.buildUrl(payNonATMDto);
			transactionService.createTransactionNonATM(payNonATMDto);
			
			responseDto.setData(urlForNonATM);
			responseDto.setStatus(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseDto;
	}
	
	@RequestMapping(value = "/response/pay_with_non_atm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDto receiveResponseForNonATM(HttpServletRequest request) throws Exception {
		ResponseDto responseDto = new ResponseDto();

		CompletePaymentRequest responseNonATM = OnePayService.parseResponseNonATM(request);
		
		// Update result of payment
		transactionService.updateTransactionNonATM(responseNonATM);
		
		if (!responseNonATM.getVpcTxnResponseCode().equals("0")) {
			// Handle error message
			responseDto.setMessage("THANH TOAN THAT BAI");
			responseDto.setStatus(HttpStatus.BAD_GATEWAY);
		} else {
			responseDto.setMessage("THANH TOAN THANH CONG");
			responseDto.setStatus(HttpStatus.OK);
		}

		return responseDto;
	}
	

}
