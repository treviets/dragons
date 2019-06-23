package net.dragons.service;

import java.util.List;

import net.dragons.dto.RoomDetailDto;
import net.dragons.jpa.entity.RoomDetail;

public interface RoomDetailService {

	List<RoomDetail> getAll();
	
	RoomDetailDto getByRoomId(Long roomId);
	
	RoomDetail create(RoomDetailDto dto);
}
