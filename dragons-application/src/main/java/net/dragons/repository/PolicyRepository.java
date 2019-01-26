package net.dragons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.dragons.jpa.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
	List<Policy> findByIdIn(List<Long> idList);
}
