package net.dragons.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParsingService {

	public static String toString(Object obj) {
		String result = "";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			result = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
