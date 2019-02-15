/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Currency;

/**
 * @author NhanNguyen
 *
 */
public interface CurrencyRepository extends JpaRepository<Currency, Integer>{
	
	Currency findById(Long id);
	
	List<Currency> findByIdIn(Long[] ids);
	
}
