/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.dragons.jpa.entity.Booking;
/**
 * @author NhanNguyen
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	List<Booking> findByRoomId(Long roomId);
	
	List<Booking> findByCustomerId(Long customerId);
	
	@Query(value = "SELECT distinct booking.roomId from Booking booking WHERE ((unix_timestamp(fromDate) >=:fromDate) OR (:fromDate is NULL) OR (:fromDate = 0)) AND ((unix_timestamp(toDate) <=:toDate) OR (:toDate is NULL) OR (:toDate = 0))")
	long[] findBookingRoom(@Param("fromDate") Long fromDate, @Param("toDate") Long toDate);
	
	@Query(value = "SELECT distinct booking.roomId from Booking booking WHERE (unix_timestamp(fromDate) =:fromDate OR :fromDate is NULL) AND (unix_timestamp(toDate) =:toDate OR :toDate is NULL)")
	List<Integer> findBookedRoom(@Param("fromDate") Long fromDate, @Param("toDate") Long toDate);

	
}
