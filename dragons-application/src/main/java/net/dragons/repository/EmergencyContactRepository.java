/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.EmergencyContact;

/**
 * @author NhanNguyen
 *
 */
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long>{
	
	EmergencyContact findById(Long id);
	
}
