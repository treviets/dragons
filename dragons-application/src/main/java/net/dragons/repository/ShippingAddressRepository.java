/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.ShippingAddress;

/**
 * @author NhanNguyen
 *
 */
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer>{
	
	
}
