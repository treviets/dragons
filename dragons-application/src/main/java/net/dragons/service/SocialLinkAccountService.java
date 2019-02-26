package net.dragons.service;

import net.dragons.jpa.entity.SocialLinkAccount;

public interface SocialLinkAccountService {
	
	SocialLinkAccount findById(Integer userId);

}
