package net.dragons.service;

import org.springframework.web.client.RestTemplate;

public class HttpService {
	
	public static String requestPayment(String url) {
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(url, null, "application/json");
		
		return result;
	}
	
	public static String receiveResponse() {
		return "";
		
	}
}
