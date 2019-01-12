/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Review;

/**
 * @author NhanNguyen
 *
 */
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	List<Review> findByRoomDetailId(Long roomId);
}
