/**
 * 
 */
package net.dragons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Customer;

/**
 * @author NhanNguyen
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Optional<Customer> findById(Long id);
	
	Customer findByPhone(String phone);
}
