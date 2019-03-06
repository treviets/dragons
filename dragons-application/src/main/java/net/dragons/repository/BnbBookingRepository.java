/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.dragons.jpa.entity.BnbBooking;
/**
 * @author NhanNguyen
 *
 */
public interface BnbBookingRepository extends JpaRepository<BnbBooking, Long>{
	
	@Query(value = "SELECT distinct booking.roomId from BnbBooking booking WHERE (unix_timestamp(fromDate) >=:fromDate OR :fromDate is NULL) AND (unix_timestamp(toDate) <=:toDate OR :toDate is NULL)")
	List<Long> findBnbBooking(@Param("fromDate") Long fromDate, @Param("toDate") Long toDate);
	
	List<BnbBooking> findByRoomId(Long roomId);
}
