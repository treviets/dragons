package net.dragons.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.constant.CompletePaymentRequest;
import net.dragons.constant.TheDragonHostConstant;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;
import net.dragons.jpa.entity.Transaction;
import net.dragons.repository.TransactionRepository;
import net.dragons.service.ParsingService;
import net.dragons.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	private long tranId = 0;
	
	@Override
	public Transaction createTransactionATM(PayATMDto payATMDto) {
		Transaction tran = new Transaction();
		
		tran.setCreatedAt(new Date());
		tran.setCustomerEmail(payATMDto.getCustomerEmail());
		tran.setCustomerId(payATMDto.getCustomerId());
		tran.setCustomerPhone(payATMDto.getCustomerPhone());
		tran.setPaymentType(TheDragonHostConstant.PAY_WITH_ATM);
		tran.setMessage("");
		tran.setTotalAmount(payATMDto.getTotalAmount());
		tran.setStatus(TheDragonHostConstant.PAYMENT_STATUS_PROCESSING);
		tran.setTransactionNumber("");
		tran.setMerchTxnRef(payATMDto.getMerchTxnRef());
		
		tran.setResponseData("");
		
		try {
			transactionRepository.save(tran);
			
			return tran;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public void updateTransactionATM(CompleteATMPaymentRequest request) {
		Optional<Transaction> existingTransaction = transactionRepository.findById(tranId);
		if (existingTransaction.isPresent()) {
			Transaction tran = existingTransaction.get();
			
			tran.setAdditionalData(request.getVpcAdditionData());
			tran.setMessage(request.getVcpMessage());
			tran.setResponseCode(request.getVpcTxnResponseCode());
			tran.setTransactionNumber(request.getVpcTransactionNo());
			
			String responseData = ParsingService.toString(request);
			tran.setResponseData(responseData);
			
			if (request.getVpcTxnResponseCode().equals("0")) {
				tran.setStatus(TheDragonHostConstant.PAYMENT_STATUS_SUCCESS);
			} else {
				tran.setStatus(TheDragonHostConstant.PAYMENT_STATUS_FAILED);
			}	
			try {
				transactionRepository.save(tran);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public Transaction createTransactionNonATM(PayNonATMDto payNonATMDto) {
		Transaction tran = new Transaction();
		
		tran.setCreatedAt(new Date());
		tran.setCustomerEmail(payNonATMDto.getCustomerEmail());
		tran.setCustomerId(payNonATMDto.getCustomerId());
		tran.setCustomerPhone(payNonATMDto.getCustomerPhone());
		tran.setPaymentType(TheDragonHostConstant.PAY_WITH_NON_ATM);
		tran.setMessage("");
		tran.setTotalAmount(payNonATMDto.getTotalAmount());
		tran.setStatus(TheDragonHostConstant.PAYMENT_STATUS_PROCESSING);
		tran.setTransactionNumber("");
		tran.setResponseData("");
		
		try {
			transactionRepository.save(tran);
			tranId = tran.getId();
			
			return tran;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void updateTransactionNonATM(CompletePaymentRequest request) {
		Optional<Transaction> existingTransaction = transactionRepository.findById(tranId);
		if (existingTransaction.isPresent()) {
			Transaction tran = existingTransaction.get();
			
			tran.setAdditionalData("");
			tran.setMessage(request.getVpcMessage());
			tran.setResponseCode(request.getVpcTxnResponseCode());
			tran.setTransactionNumber(request.getVpcTransactionNo());
			tran.setResponseData("");
			
			if (request.getVpcTxnResponseCode().equals("0")) {
				tran.setStatus(TheDragonHostConstant.PAYMENT_STATUS_SUCCESS);
			} else {
				tran.setStatus(TheDragonHostConstant.PAYMENT_STATUS_FAILED);
			}
			
			try {
				transactionRepository.save(tran);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Transaction> findAll() {		
		return transactionRepository.findAll();
	}

	@Override
	public List<Transaction> findByPaymentType(String paymentType) {
		return transactionRepository.findByPaymentType(paymentType);
	}

	@Override
	public List<Transaction> findByPaymentStatus(String status) {
		return transactionRepository.findByStatus(status);
	}

	@Override
	public List<Transaction> findByCustomerId(long customerId) {
		return transactionRepository.findByCustomerId(customerId);
	}


}
