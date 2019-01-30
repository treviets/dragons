/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.GuestProfile;

/**
 * @author NhanNguyen
 *
 */
public interface GuestProfileRepository extends JpaRepository<GuestProfile, Long>{
	
	GuestProfile findById(Long id);
}
