package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.Counselor;
import com.Team4.web.mongodbclass.CslSch;
import com.Team4.web.mongodbclass.Users;

public interface CslSchRepo extends MongoRepository<CslSch, String>{
	
}