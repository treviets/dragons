package net.dragons.service;

import org.springframework.web.client.RestTemplate;

public class HttpService {
	
	public static String requestPayment(String url) {
		RestTemplate restTemplate = new RestTemplate();
		
		String response = restTemplate.getForObject(url, String.class);
		
		return response;
	}
	
	public static String receiveResponse() {
		return "";
		
	}
}
