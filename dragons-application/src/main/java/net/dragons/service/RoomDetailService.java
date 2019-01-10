package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.RoomDetail;

public interface RoomDetailService {

	List<RoomDetail> getAll();
	
	RoomDetail getByRoomId(Long roomId);
}
