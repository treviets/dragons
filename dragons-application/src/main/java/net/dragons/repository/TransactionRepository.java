/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Transaction;

/**
 * @author NhanNguyen
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	Transaction findById(Long id);
	
	
}