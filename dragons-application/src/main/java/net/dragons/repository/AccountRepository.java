/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Account;

/**
 * @author NhanNguyen
 *
 */
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	Account findByUsername(String username);
	
	List<Account> findByRoleId(int roleId);
	
	Account findByUsernameAndPassword(String username, String password);
}
