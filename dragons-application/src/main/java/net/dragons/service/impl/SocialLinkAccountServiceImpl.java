package net.dragons.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import net.dragons.jpa.entity.SocialLinkAccount;
import net.dragons.repository.SocialLinkReponsitory;
import net.dragons.service.SocialLinkAccountService;

public class SocialLinkAccountServiceImpl implements SocialLinkAccountService {
	
	@Autowired SocialLinkReponsitory socialLinkAccountReponsetory;

	@Override
	public SocialLinkAccount findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
