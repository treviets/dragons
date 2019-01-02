/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Customer;

/**
 * @author NhanNguyen
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findById(Long id);
	
	List<Customer> findByUsername(String username);
	
}
