/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Configuration;

/**
 * @author NhanNguyen
 *
 */
public interface ConfigurationRepository extends JpaRepository<Configuration, Long>{
	
}
