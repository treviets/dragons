package net.dragons.service;

import java.util.List;

import net.dragons.onepay.CompleteATMPaymentRequest;
import net.dragons.onepay.CompletePaymentRequest;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;
import net.dragons.jpa.entity.Transaction;

public interface TransactionService {
	
	Transaction createTransactionATM(PayATMDto payATMDto);
	
	Transaction createTransactionNonATM(PayNonATMDto payNonATMDto);
	
	void updateTransactionATM(CompleteATMPaymentRequest request);
	
	Transaction updateTransactionNonATM(CompletePaymentRequest request);
	
	List<Transaction> findAll();
	
	List<Transaction> findByPaymentType(String paymentType);
	
	List<Transaction> findByPaymentStatus(String status);
	
	List<Transaction> findByCustomerId(long customerId);
	
}
