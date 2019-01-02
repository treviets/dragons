/**
 * 
 */
package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Booking;

/**
 * @author NhanNguyen
 *
 */
public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	List<Booking> findByHotelId(Integer hotelId);
	
	List<Booking> findByRoomId(Integer roomId);
	
	List<Booking> findByCustomerId(Integer customerId);
	
	
}
