package net.dragons.service;

import java.util.List;

import net.dragons.dto.RoomImageDto;
import net.dragons.jpa.entity.RoomImage;

public interface RoomImageService {

	void createList(RoomImageDto roomImageDto);
	
	List<RoomImage> findByRoomId(Long roomId);
}
