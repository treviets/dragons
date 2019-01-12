package net.dragons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.jpa.entity.Review;
import net.dragons.repository.ReviewRepository;
import net.dragons.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public List<Review> getByRoomId(Long roomId) {
		return reviewRepository.findByRoomId(roomId);
	}
	


}
