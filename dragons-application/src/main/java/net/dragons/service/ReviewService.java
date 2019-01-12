package net.dragons.service;

import java.util.List;

import net.dragons.jpa.entity.Review;

public interface ReviewService {

	List<Review> getByRoomId(Long roomId);
	
}
