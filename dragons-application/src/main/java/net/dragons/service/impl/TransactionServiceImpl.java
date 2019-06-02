package net.dragons.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.dto.TransactionDto;
import net.dragons.jpa.entity.Transaction;
import net.dragons.repository.TransactionRepository;
import net.dragons.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public Long create(TransactionDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		
		Transaction tran = modelMapper.map(dto, Transaction.class);
		transactionRepository.save(tran);
		
		return tran.getId();
	}
	
	

}
