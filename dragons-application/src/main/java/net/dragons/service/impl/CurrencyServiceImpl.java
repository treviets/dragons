package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Currency;
import net.dragons.repository.CurrencyRepository;
import net.dragons.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;

	@Override
	public Currency findById(Long id) {
		return currencyRepository.findById(id);
	}

	public List<Currency> findAll() {
		return currencyRepository.findAll();
	}
	
	@Override
	public List<Currency> findByIds(Long[] ids) {	
		return currencyRepository.findByIdIn(ids);
	}

	
}
