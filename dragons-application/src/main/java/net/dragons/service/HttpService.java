package net.dragons.service;

import org.springframework.web.client.RestTemplate;

public class HttpService {
	
	public static String requestPayment(String url) {
		RestTemplate restTemplate = new RestTemplate();
		
		String test = restTemplate.getForObject(url, String.class);
		
		System.out.println(test);
		
		return test;
	}
	
	public static String receiveResponse() {
		return "";
		
	}
}
