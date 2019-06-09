package net.dragons.service;

import java.util.List;

import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.constant.CompletePaymentRequest;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;
import net.dragons.jpa.entity.Transaction;

public interface TransactionService {
	
	long createTransactionATM(PayATMDto payATMDto);
	
	long createTransactionNonATM(PayNonATMDto payNonATMDto);
	
	void updateTransactionATM(CompleteATMPaymentRequest request);
	
	void updateTransactionNonATM(CompletePaymentRequest request);
	
	List<Transaction> findAll();
	
	List<Transaction> findByPaymentType(String paymentType);
	
	List<Transaction> findByPaymentStatus(String status);
	
	List<Transaction> findByCustomerId(long customerId);
}
