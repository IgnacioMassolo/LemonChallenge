package com.imassolo.controller;

import com.imassolo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppControllerTest {

    private UserService userService;
    private AppController instance;

    @BeforeEach
    public void setUp(){
        userService = mock(UserService.class);
        instance = new AppController(userService);
    }

    @Test //dummy test
    public void when_new_request_comes_must_process(){
        Long userId = 1L;
        ResponseEntity<String> okResponse = ResponseEntity
                .ok()
                .body(("{\"message\":\"Everyone can go and fuck off.\",\"subtitle\":\"- Ghandi\"}"));
        when(userService.getMessage(userId)).thenReturn(okResponse);
        ResponseEntity<String> response = instance.getMessage(userId);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void when_request_without_user_id_comes_must_reject(){
        ResponseEntity<String> response = instance.getMessage(null);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
