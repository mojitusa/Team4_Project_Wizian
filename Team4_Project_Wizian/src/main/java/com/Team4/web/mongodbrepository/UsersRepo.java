package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.Users;

public interface UsersRepo extends MongoRepository<Users, String>{
	
	@Query("{'user_no': ?0}")
	Users findByUserNo(String userNo);
	
}
