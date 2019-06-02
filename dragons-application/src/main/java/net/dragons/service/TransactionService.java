package net.dragons.service;

import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.dto.PayATMDto;

public interface TransactionService {
	
	long createTransactionATM(PayATMDto payATMDto);
	
	void updateTransactionATM(CompleteATMPaymentRequest request);
}
