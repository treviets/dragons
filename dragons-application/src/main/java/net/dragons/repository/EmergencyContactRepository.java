/**
 * 
 */
package net.dragons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.EmergencyContact;

/**
 * @author NhanNguyen
 *
 */
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long>{
	
	Optional<EmergencyContact> findById(Long id);
	
}
