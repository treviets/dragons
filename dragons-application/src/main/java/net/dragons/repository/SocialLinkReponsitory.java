package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.SocialLinkAccount;

/**
 * @author mrThor
 *
 */
public interface SocialLinkReponsitory extends JpaRepository<SocialLinkAccount, Integer>{
	SocialLinkAccount findByUserId(Integer userId);
}
