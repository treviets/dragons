/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Hotel;

/**
 * @author NhanNguyen
 *
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
	Hotel findById(Integer holteId);
}
