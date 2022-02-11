package com.imassolo.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class FoaasService {

    private static final String URL = "https://foaas.com/everyone/Ghandi";
    private static final String USER_AGENT = "user-agent";
    private static final String APPLICATION = "application";

    public FoaasService(){}

    public ResponseEntity<String> getFoaasMessage() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add(USER_AGENT, APPLICATION);

        HttpEntity request = new HttpEntity(headers);

        return restTemplate.exchange(
                URL,
                HttpMethod.GET,
                request,
                String.class,
                1
        );
    }
}


