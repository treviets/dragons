package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.dragons.dto.RoomImageDto;
import net.dragons.jpa.entity.RoomImage;
import net.dragons.repository.RoomImageRepository;
import net.dragons.service.RoomImageService;

@Service
public class RoomImageServiceImpl implements RoomImageService {

	@Autowired
	RoomImageRepository roomImageRepository;
	
	@Override
	public void createList(RoomImageDto roomImageDto) {
		List<MultipartFile> images = roomImageDto.getImages();
		Long roomId = roomImageDto.getRoomId();
		
		int maxId = getMaxId() + 1;

		for (int i = 0; i < images.size(); i++) {
			// Save info in database
			
			Integer imageName = maxId + i;
			String image = "/static/img/room/" + roomId.toString() + "/" + imageName.toString() + ".jpg";
			
			RoomImage roomImage = new RoomImage();
			roomImage.setImage(image);
			roomImage.setRoomId(roomId);
			
			// Save image in static folder
			
		}
	}

	
	private int getMaxId() {
		List<RoomImage> roomImages = roomImageRepository.findAll();
		if (roomImages.size() == 0) {
			return 0;
		}
		
		RoomImage roomImage = roomImages.get(roomImages.size() - 1);
		if (roomImage == null) {
			return 0;
		}
		
		String imageUrl = roomImage.getImage();
		String[] arr = imageUrl.split("/");
		
		String imageExt = arr[arr.length - 1];
		String[] image = imageExt.split(".");
		int id = Integer.parseInt(image[0]);
		
		return id;
	}
	
	
	

}
