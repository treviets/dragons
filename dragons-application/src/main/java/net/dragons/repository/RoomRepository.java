/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import net.dragons.jpa.entity.Room;

/**
 * @author NhanNguyen
 *
 */
public interface RoomRepository extends JpaRepository<Room, Integer>{
	
	List<Room> findByProvince(Integer city);
	
	List<Room> findByDistrict(Integer district);
	
	List<Room> findByStatus(Integer status);
	
	List<Room> findByHomeId(Long homeId);
	
	@Query(value = "SELECT room FROM Room room WHERE id NOT IN (:ids) AND (province =:province OR :province is NULL) AND (numberOfGuest =:numberOfGuest OR :numberOfGuest is NULL)")
	List<Room> findRoomsNotBooked(@Param("ids") long[] ids, @Param("province") Integer province, @Param("numberOfGuest") Integer numberOfGuest);
	
}
