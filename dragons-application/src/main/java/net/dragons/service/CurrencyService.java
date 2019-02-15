package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Currency;

public interface CurrencyService {

	Currency findById(Long customerId);
	
	List<Currency> findAll();
	
	List<Currency> findByIds(Long[] ids);
}
