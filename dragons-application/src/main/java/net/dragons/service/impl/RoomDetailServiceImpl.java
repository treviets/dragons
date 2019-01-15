package net.dragons.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dragons.dto.RoomDetailDto;
import net.dragons.jpa.entity.Amenity;
import net.dragons.jpa.entity.RoomDetail;
import net.dragons.repository.AmenityRepository;
import net.dragons.repository.RoomDetailRepository;
import net.dragons.service.RoomDetailService;

@Service
public class RoomDetailServiceImpl implements RoomDetailService {

	@Autowired
	RoomDetailRepository roomDetailRepository;
	
	@Autowired 
	AmenityRepository amenityRepository;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<RoomDetail> getAll() {
		return roomDetailRepository.findAll();
	}
	
	ModelMapper mapper;
	
	@PostConstruct
	public void initialize() {
		mapper = new ModelMapper();
	}

	@Override
	public RoomDetailDto getByRoomId(Long roomId) {
		RoomDetailDto roomDetailDto = new RoomDetailDto();
		RoomDetail detail = new RoomDetail();
		detail = roomDetailRepository.findByRoomId(roomId);
		String amenity =  detail.getAmenity();
		String[] amenitiesId = amenity.split(",");
		ArrayList<Long> idList = new ArrayList<Long>();
		for(String id : amenitiesId) idList.add(Long.valueOf(id).longValue());
		mapper.map(detail, roomDetailDto);
		if (idList.size() > 0) {
			List<Amenity> amenities = amenityRepository.findByIdIn(idList);
			roomDetailDto.setAmenities(amenities);
		}
		
		return roomDetailDto;
	}
	private List<RoomDetailDto> map(List<RoomDetail> source) {
		ArrayList<RoomDetailDto> rtn = new ArrayList<>();
		source.stream().map((entity) -> {
			RoomDetailDto dto = new RoomDetailDto();
			mapper.map(entity, dto);
			return dto;
		}).forEachOrdered((dto) -> {
			rtn.add(dto);
		});
		return rtn;
	}


	
	

}
