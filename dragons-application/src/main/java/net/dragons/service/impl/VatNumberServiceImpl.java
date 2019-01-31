package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.VatNumber;
import net.dragons.repository.VatNumberRepository;
import net.dragons.service.VatNumberService;

@Service
public class VatNumberServiceImpl implements VatNumberService {

	@Autowired
	VatNumberRepository vatNumberRepository;

	@Override
	public List<VatNumber> findByCustomerId(Long customerId) {
		return vatNumberRepository.findByCustomerId(customerId);
	}

	
	
}
