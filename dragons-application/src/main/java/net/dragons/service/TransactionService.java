package net.dragons.service;

import net.dragons.dto.TransactionDto;

public interface TransactionService {
	
	Long create(TransactionDto dto);
}
