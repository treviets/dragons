package net.dragons.service;

import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.constant.CompletePaymentRequest;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;

public interface TransactionService {
	
	long createTransactionATM(PayATMDto payATMDto);
	
	long createTransactionNonATM(PayNonATMDto payNonATMDto);
	
	void updateTransactionATM(CompleteATMPaymentRequest request);
	
	void updateTransactionNonATM(CompletePaymentRequest request);
}
