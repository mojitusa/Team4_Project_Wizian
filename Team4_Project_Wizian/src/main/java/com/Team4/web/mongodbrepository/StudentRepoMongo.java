package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.StudentMongo;
import com.Team4.web.mongodbclass.UsersMongo;

public interface StudentRepoMongo extends MongoRepository<StudentMongo, String>{

	StudentMongo findByUsers(UsersMongo users);
	
}
