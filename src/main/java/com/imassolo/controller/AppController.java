package com.imassolo.controller;

import com.imassolo.service.UserService;
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
	public void getMessage(@RequestParam Long userId) {
		userService.getMessage(userId);
	}
}
