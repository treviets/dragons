package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Language;

public interface LanguageService {

	Language findById(Long customerId);
	
	List<Language> findAll();
	
}
