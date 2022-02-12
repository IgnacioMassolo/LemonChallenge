package com.imassolo.service;

import com.imassolo.client.FoaasClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private FoaasClient foaasClient;
    private UserService instance;

    @BeforeEach
    public void setUp() {
        foaasClient = mock(FoaasClient.class);
        instance = new UserService(foaasClient);
    }

    @Test
    public void when_new_user_arrives_must_process() {
        Long userId = 1L;
        ResponseEntity<String> okResponse = ResponseEntity
                .ok()
                .body(("{\"message\":\"Everyone can go and fuck off.\",\"subtitle\":\"- Ghandi\"}"));
        when(foaasClient.getFoaasMessage()).thenReturn(okResponse);
        ResponseEntity<String> response = instance.getMessage(userId);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void when_new_user_makes_5_request_must_process_all() {
        Long userId = 1L;
        ResponseEntity<String> okResponse = ResponseEntity
                .ok()
                .body(("{\"message\":\"Everyone can go and fuck off.\",\"subtitle\":\"- Ghandi\"}"));
        when(foaasClient.getFoaasMessage()).thenReturn(okResponse);
        ResponseEntity<String> response1 = instance.getMessage(userId);
        ResponseEntity<String> response2 = instance.getMessage(userId);
        ResponseEntity<String> response3 = instance.getMessage(userId);
        ResponseEntity<String> response4 = instance.getMessage(userId);
        ResponseEntity<String> response5 = instance.getMessage(userId);
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response2.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response3.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response4.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response5.getStatusCode());
    }

    @Test
    public void when_new_user_makes_6_request_must_reject_the_last() {
        Long userId = 1L;
        ResponseEntity<String> okResponse = ResponseEntity
                .ok()
                .body(("{\"message\":\"Everyone can go and fuck off.\",\"subtitle\":\"- Ghandi\"}"));
        when(foaasClient.getFoaasMessage()).thenReturn(okResponse);
        ResponseEntity<String> response1 = instance.getMessage(userId);
        ResponseEntity<String> response2 = instance.getMessage(userId);
        ResponseEntity<String> response3 = instance.getMessage(userId);
        ResponseEntity<String> response4 = instance.getMessage(userId);
        ResponseEntity<String> response5 = instance.getMessage(userId);
        ResponseEntity<String> response6 = instance.getMessage(userId);
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response2.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response3.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response4.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response5.getStatusCode());
        Assertions.assertEquals(HttpStatus.LOCKED, response6.getStatusCode());
    }

    @Test
    public void when_2_new_users_makes_5_request_each_must_process_all() {
        Long userId1 = 1L;
        Long userId2 = 2L;
        ResponseEntity<String> okResponse = ResponseEntity
                .ok()
                .body(("{\"message\":\"Everyone can go and fuck off.\",\"subtitle\":\"- Ghandi\"}"));
        when(foaasClient.getFoaasMessage()).thenReturn(okResponse);
        ResponseEntity<String> response1 = instance.getMessage(userId1);
        ResponseEntity<String> response2 = instance.getMessage(userId2);
        ResponseEntity<String> response3 = instance.getMessage(userId1);
        ResponseEntity<String> response4 = instance.getMessage(userId2);
        ResponseEntity<String> response5 = instance.getMessage(userId1);
        ResponseEntity<String> response6 = instance.getMessage(userId2);
        ResponseEntity<String> response7 = instance.getMessage(userId1);
        ResponseEntity<String> response8 = instance.getMessage(userId2);
        ResponseEntity<String> response9 = instance.getMessage(userId1);
        ResponseEntity<String> response10 = instance.getMessage(userId2);
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response2.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response3.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response4.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response5.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response6.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response7.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response8.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response9.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response10.getStatusCode());
    }

    @Test
    public void when_2_new_users_makes_6_request_each_must_process_reject_2() {
        Long userId1 = 1L;
        Long userId2 = 2L;
        ResponseEntity<String> okResponse = ResponseEntity
                .ok()
                .body(("{\"message\":\"Everyone can go and fuck off.\",\"subtitle\":\"- Ghandi\"}"));
        when(foaasClient.getFoaasMessage()).thenReturn(okResponse);
        ResponseEntity<String> response1 = instance.getMessage(userId1);
        ResponseEntity<String> response2 = instance.getMessage(userId2);
        ResponseEntity<String> response3 = instance.getMessage(userId1);
        ResponseEntity<String> response4 = instance.getMessage(userId2);
        ResponseEntity<String> response5 = instance.getMessage(userId1);
        ResponseEntity<String> response6 = instance.getMessage(userId2);
        ResponseEntity<String> response7 = instance.getMessage(userId1);
        ResponseEntity<String> response8 = instance.getMessage(userId2);
        ResponseEntity<String> response9 = instance.getMessage(userId1);
        ResponseEntity<String> response10 = instance.getMessage(userId2);
        ResponseEntity<String> response11 = instance.getMessage(userId1);
        ResponseEntity<String> response12 = instance.getMessage(userId2);
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response2.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response3.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response4.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response5.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response6.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response7.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response8.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response9.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response10.getStatusCode());
        Assertions.assertEquals(HttpStatus.LOCKED, response11.getStatusCode());
        Assertions.assertEquals(HttpStatus.LOCKED, response12.getStatusCode());
    }

    //To check that the service will be enabled again after 10 seconds please uncomment the next line and run the test.
    //@Test
    public void when_a_new_user_is_locked_after_10_seconds_must_process_again() throws InterruptedException {
        Long userId = 1L;
        ResponseEntity<String> okResponse = ResponseEntity
                .ok()
                .body(("{\"message\":\"Everyone can go and fuck off.\",\"subtitle\":\"- Ghandi\"}"));
        when(foaasClient.getFoaasMessage()).thenReturn(okResponse);
        ResponseEntity<String> response1 = instance.getMessage(userId);
        ResponseEntity<String> response2 = instance.getMessage(userId);
        ResponseEntity<String> response3 = instance.getMessage(userId);
        ResponseEntity<String> response4 = instance.getMessage(userId);
        ResponseEntity<String> response5 = instance.getMessage(userId);
        ResponseEntity<String> response6 = instance.getMessage(userId);
        Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response2.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response3.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response4.getStatusCode());
        Assertions.assertEquals(HttpStatus.OK, response5.getStatusCode());
        Assertions.assertEquals(HttpStatus.LOCKED, response6.getStatusCode());

        sleep(11000);

        ResponseEntity<String> response7 = instance.getMessage(userId);
        Assertions.assertEquals(HttpStatus.OK, response7.getStatusCode());
    }


}
