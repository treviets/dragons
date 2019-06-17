/**
 * 
 */
package net.dragons.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Transaction;

/**
 * @author NhanNguyen
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	Optional<Transaction> findById(Long id);
	
	List<Transaction> findByCustomerId(long id);

	List<Transaction> findByStatus(String status);
	
	List<Transaction> findByPaymentType(String paymentType);
	
}
