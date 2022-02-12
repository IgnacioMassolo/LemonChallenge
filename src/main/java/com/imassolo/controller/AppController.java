package com.imassolo.controller;

import com.imassolo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {

	private UserService userService;

	public AppController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public ResponseEntity<String> getMessage(@RequestParam @Nullable Long userId) {
		if(userId == null){
			return ResponseEntity.badRequest().body("Please add the 'userId' header. " +
					"'/message?userId=123'");
		}
		return userService.getMessage(userId);
	}
}
