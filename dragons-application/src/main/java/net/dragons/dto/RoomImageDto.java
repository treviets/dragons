package net.dragons.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RoomImageDto {

	private List<MultipartFile> images;
	
	private Long roomId;

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	
	
	
}
