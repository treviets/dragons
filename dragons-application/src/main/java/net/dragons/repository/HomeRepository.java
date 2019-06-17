/**
 * 
 */
package net.dragons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Home;

/**
 * @author NhanNguyen
 *
 */
public interface HomeRepository extends JpaRepository<Home, Long>{
	
	Optional<Home> findById(Long id);
}
