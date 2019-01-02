/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Customer;

/**
 * @author NhanNguyen
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findById(Long id);
	
	Customer findByEmail(String email);
	
	Customer findByPhone(String phone);
	
	Customer findByReferenceCode(String refereneCode);
}
