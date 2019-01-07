/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import net.dragons.jpa.entity.Room;

/**
 * @author NhanNguyen
 *
 */
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	List<Room> findByCity(Integer city);
	
	List<Room> findByDistrict(Integer district);
	
	List<Room> findByStatus(Integer status);
}
