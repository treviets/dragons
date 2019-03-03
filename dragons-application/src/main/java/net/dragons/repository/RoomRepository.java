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
public interface RoomRepository extends JpaRepository<Room, Integer> {

	List<Room> findByProvince(Integer city);

	List<Room> findByDistrict(Integer district);

	List<Room> findByStatus(Integer status);

	List<Room> findByHomeId(Long homeId);

	@Query(value = "SELECT room FROM Room room WHERE id NOT IN (:ids) "
			+ "AND (homeId =:homeId OR :homeId is NULL OR :homeId = 0) "
			+ "AND (numberOfGuest >=:numberOfGuest OR :numberOfGuest is NULL OR :numberOfGuest = 0) "
			+ "AND ((price >= :min OR :min is NULL) AND (price <= :max OR :max is NULL)) "
			+ "AND (roomType = :roomtype OR :roomtype = 0 OR :roomtype is NULL)")
	List<Room> findRoomsNotBooked(@Param("roomtype") Integer roomtype, @Param("min") String min,
			@Param("max") String max, @Param("ids") List<Long> ids, @Param("homeId") Long homeId,
			@Param("numberOfGuest") Integer numberOfGuest);

}
