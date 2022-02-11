package com.imassolo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class UserService {

	private HashMap<Long, Queue<LocalTime>> usersMap;
	private FoaaService foaaService;

	public UserService(FoaaService foaaService) {
		this.usersMap = new HashMap<>();
		this.foaaService = foaaService;
	}

	public void getMessage(Long userId) {
		if(usersMap.containsKey(userId)){
			Queue<LocalTime> lastAccesses = usersMap.get(userId);
			if(lastAccesses.size()>=5){
				if(lastAccesses.peek().until(LocalTime.now(), ChronoUnit.SECONDS) <= 10){
					throw new RuntimeException("No se puede bro");
				}
				lastAccesses.remove();
			}
			lastAccesses.add(LocalTime.now());
		} else {
			LinkedList<LocalTime> newQueue = new LinkedList<>();
			newQueue.add(LocalTime.now());
			usersMap.put(userId, newQueue);
		}

		//TODO llamar al fooas
	}

}
