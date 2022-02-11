package com.imassolo.repository;

import com.imassolo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends MongoRepository<User, Long> {

	List<LocalDateTime> findTimeByUserId(Long userId);

}
