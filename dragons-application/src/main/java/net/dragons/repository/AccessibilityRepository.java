package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Accessibility;

public interface AccessibilityRepository extends JpaRepository<Accessibility, Long>{
	List<Accessibility> findByIdIn(List<Long> idList);


}
