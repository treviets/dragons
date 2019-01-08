package net.dragons.service;

import net.dragons.jpa.entity.Account;

public interface AccountService {

	Account getAccount(String username, String password);
	
}
