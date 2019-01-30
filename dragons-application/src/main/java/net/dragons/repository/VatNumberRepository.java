/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.VatNumber;
/**
 * @author NhanNguyen
 *
 */
public interface VatNumberRepository extends JpaRepository<VatNumber, Long>{
	
	List<VatNumber> findByCustomerId(Long customerId);
	
	
}
