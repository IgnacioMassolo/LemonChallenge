package com.imassolo.client;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FoaasClientTest {

    private FoaasClient instance;

    @BeforeEach
    public void setUp(){
        instance = new FoaasClient();
    }

    @Test
    public void when_calling_foaas_must_process(){
        ResponseEntity<String> response = instance.getFoaasMessage();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
