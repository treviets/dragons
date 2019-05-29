package net.dragons.service;

import org.springframework.web.client.RestTemplate;

public class HttpService {
	
	public static void requestPayment(String url) {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getForObject(url, null, "application/json");
	}
	
	public static String receiveResponse() {
		return "";
		
	}
}
