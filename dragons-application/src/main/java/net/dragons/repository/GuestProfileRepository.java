/**
 * 
 */
package net.dragons.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.GuestProfile;

/**
 * @author NhanNguyen
 *
 */
public interface GuestProfileRepository extends JpaRepository<GuestProfile, Long>{
	
	Optional<GuestProfile> findById(Long id);
	
	List<GuestProfile> findByCustomerId(Long customerId);
	
	
}
