package net.dragons.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Room;
import net.dragons.repository.RoomRepository;
import net.dragons.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getByFilter(Integer city, Integer from, Integer to, Integer numberOfGuest) {
		String sql = "SELECT r FROM Room r WHERE r.status = 1";
		if (city != 0 && city != null) {
			sql += " AND r.city = " + city;
		}
		
		if (numberOfGuest != 0 && numberOfGuest != null) {
			sql += " AND r.numberOfGuest = " + numberOfGuest;
		}
		
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	
	

}
