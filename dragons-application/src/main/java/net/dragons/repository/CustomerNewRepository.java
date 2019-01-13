package net.dragons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.CustomerNewEntity;

public interface CustomerNewRepository extends JpaRepository<CustomerNewEntity, Long>{
	
	CustomerNewEntity findByEmail(String email);
	
}