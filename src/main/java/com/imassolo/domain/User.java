package com.imassolo.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class User {

	@Id
	public Long userId;

	public LocalDateTime time;


	public User(){}

	public User(Long userId, LocalDateTime time){
		this.userId = userId;
		this.time = time;
	}




}
