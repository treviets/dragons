/**
 * 
 */
package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Client;

/**
 * @author Vincent
 *
 */
public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	Client findByUsername(String username);
}
