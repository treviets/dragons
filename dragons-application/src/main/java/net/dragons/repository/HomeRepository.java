/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Home;

/**
 * @author NhanNguyen
 *
 */
public interface HomeRepository extends JpaRepository<Home, Integer>{
	
	Home findById(Integer holteId);
}
