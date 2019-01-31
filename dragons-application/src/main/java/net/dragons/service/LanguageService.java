package net.dragons.service;

import net.dragons.jpa.entity.Language;

public interface LanguageService {

	Language findById(Long customerId);
	
}
