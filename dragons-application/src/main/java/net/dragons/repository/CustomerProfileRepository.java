/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.CustomerProfile;

/**
 * @author NhanNguyen
 *
 */
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long>{
	
	CustomerProfile findById(Long id);
	
	CustomerProfile findByPhone(String phone);
	
	
}
