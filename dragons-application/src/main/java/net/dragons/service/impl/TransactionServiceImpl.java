package net.dragons.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.constant.CompleteATMPaymentRequest;
import net.dragons.constant.CompletePaymentRequest;
import net.dragons.dto.PayATMDto;
import net.dragons.dto.PayNonATMDto;
import net.dragons.jpa.entity.Transaction;
import net.dragons.repository.TransactionRepository;
import net.dragons.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	private long tranId = 0;
	
	@Override
	public long createTransactionATM(PayATMDto payATMDto) {
		Transaction tran = new Transaction();
		
		tran.setCreatedAt(new Date());
		tran.setCustomerEmail(payATMDto.getCustomerEmail());
		tran.setCustomerId(payATMDto.getCustomerId());
		tran.setCustomerPhone(payATMDto.getCustomerPhone());
		tran.setPaymentType("ATM");
		tran.setMessage("");
		tran.setTotalAmount(payATMDto.getTotalAmount());
		tran.setStatus("PROCESSING");
		tran.setTransactionNumber("");
		
		try {
			transactionRepository.save(tran);
			tranId = tran.getId();
			
			return tranId;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		
	}
	
	@Override
	public void updateTransactionATM(CompleteATMPaymentRequest request) {
		Transaction tran = transactionRepository.findOne(tranId);
		
		tran.setAdditionalData(request.getVpcAdditionData());
		tran.setMessage(request.getVcpMessage());
		tran.setResponseCode(request.getVpcTxnResponseCode());
		tran.setTransactionNumber(request.getVpcTransactionNo());
		tran.setStatus("FINISHED");
		
		try {
			transactionRepository.save(tran);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public long createTransactionNonATM(PayNonATMDto payNonATMDto) {
		Transaction tran = new Transaction();
		
		tran.setCreatedAt(new Date());
		tran.setCustomerEmail(payNonATMDto.getCustomerEmail());
		tran.setCustomerId(payNonATMDto.getCustomerId());
		tran.setCustomerPhone(payNonATMDto.getCustomerPhone());
		tran.setPaymentType("Non_ATM");
		tran.setMessage("");
		tran.setTotalAmount(payNonATMDto.getTotalAmount());
		tran.setStatus("PROCESSING");
		tran.setTransactionNumber("");
		
		try {
			transactionRepository.save(tran);
			tranId = tran.getId();
			
			return tranId;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public void updateTransactionNonATM(CompletePaymentRequest request) {
		Transaction tran = transactionRepository.findOne(tranId);
		
		tran.setAdditionalData("");
		tran.setMessage(request.getVpcMessage());
		tran.setResponseCode(request.getVpcTxnResponseCode());
		tran.setTransactionNumber(request.getVpcTransactionNo());
		tran.setStatus("FINISHED");
		
		try {
			transactionRepository.save(tran);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}


}
