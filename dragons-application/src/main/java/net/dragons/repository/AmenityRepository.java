package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Amenity;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
	List<Amenity> findByIdIn(List<Long> idList);
	
}
