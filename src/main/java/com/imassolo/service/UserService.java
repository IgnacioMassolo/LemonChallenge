package com.imassolo.service;

import com.imassolo.domain.User;
import com.imassolo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

public class UserService {

	private UserRepository repository;
	private FoaaService foaaService;

	public UserService(UserRepository userRepository, FoaaService foaaService) {
		this.repository = userRepository;
		this.foaaService = foaaService;
	}

	public void getMessage(Long userId) {
		List<LocalDateTime> last = repository.findTimeByUserId(userId);
	}

}
