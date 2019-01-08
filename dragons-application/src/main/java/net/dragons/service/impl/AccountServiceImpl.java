package net.dragons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Account;
import net.dragons.repository.AccountRepository;
import net.dragons.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account getAccount(String username, String password) {
		return accountRepository.findByUsernameAndPassword(username, password);
	}

}
