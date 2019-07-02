/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.RoomImage;

/**
 * @author NhanNguyen
 *
 */
public interface RoomImageRepository extends JpaRepository<RoomImage, Integer> {
	
	List<RoomImage> findByRoomId(Long roomId);
}
