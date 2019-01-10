package net.dragons.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.RoomDetail;
import net.dragons.repository.RoomDetailRepository;
import net.dragons.service.RoomDetailService;

@Service
public class RoomDetailServiceImpl implements RoomDetailService {

	@Autowired
	RoomDetailRepository roomDetailRepository;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<RoomDetail> getAll() {
		return roomDetailRepository.findAll();
	}

	@Override
	public RoomDetail getByRoomId(Long roomId) {
		return roomDetailRepository.findByRoomId(roomId);
	}



	
	

}
