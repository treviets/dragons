/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.RoomDetail;

/**
 * @author NhanNguyen
 *
 */
public interface RoomDetailRepository extends JpaRepository<RoomDetail, Long>{
	
	RoomDetail findByRoomId(Long roomId);
}
