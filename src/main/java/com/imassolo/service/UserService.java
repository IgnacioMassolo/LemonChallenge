package com.imassolo.service;

import com.imassolo.client.FoaasClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class UserService {

	private final HashMap<Long, Queue<LocalTime>> usersMap;
	private final FoaasClient foaasClient;

	public UserService(FoaasClient foaasClient) {
		this.usersMap = new HashMap<>();
		this.foaasClient = foaasClient;
	}

	public ResponseEntity<String> getMessage(Long userId) {
		if(usersMap.containsKey(userId)){
			Queue<LocalTime> lastAccesses = usersMap.get(userId);
			if(lastAccesses.size()>=5){
				if(lastAccesses.peek().until(LocalTime.now(), ChronoUnit.SECONDS) <= 10){
					return ResponseEntity.status(HttpStatus.LOCKED).body("User is locked.");
				}
				lastAccesses.remove();
			}
			lastAccesses.add(LocalTime.now());
		} else {
			LinkedList<LocalTime> newQueue = new LinkedList<>();
			newQueue.add(LocalTime.now());
			usersMap.put(userId, newQueue);
		}

		return foaasClient.getFoaasMessage();

	}

}
