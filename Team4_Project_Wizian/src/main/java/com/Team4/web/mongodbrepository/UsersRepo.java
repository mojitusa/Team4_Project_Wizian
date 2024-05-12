package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.web.mongodbclass.Users;

public interface UsersRepo extends MongoRepository<Users, String>{
	
}
