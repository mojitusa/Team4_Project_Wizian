package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.UsersMongo;

public interface UsersRepo extends MongoRepository<UsersMongo, String>{
	
	@Query("{'user_no': ?0}")
	UsersMongo findByUserNo(String userNo);
	
}
