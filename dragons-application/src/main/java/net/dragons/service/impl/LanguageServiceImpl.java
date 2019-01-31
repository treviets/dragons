package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Language;
import net.dragons.repository.LanguageRepository;
import net.dragons.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	LanguageRepository languageRepository;

	@Override
	public Language findById(Long id) {
		return languageRepository.findById(id);
	}

	public List<Language> findAll() {
		return languageRepository.findAll();
	}
	
	
}
