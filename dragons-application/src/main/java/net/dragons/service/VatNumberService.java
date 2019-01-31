package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.VatNumber;

public interface VatNumberService {

	List<VatNumber>	findByCustomerId(Long customerId);
	
}
