package com.imassolo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FoaaService {

	private RestTemplate restTemplate;

	private static String URL = "htts://foaas.com/everyone/Ghandi";
	private static String APPLICATION_JSON = "application/json";

	public FoaaService(){
		restTemplate = new RestTemplate();
	}

	public void getFoaasMessage(){
		restTemplate.getForObject(URL, String.class);
	}
}
