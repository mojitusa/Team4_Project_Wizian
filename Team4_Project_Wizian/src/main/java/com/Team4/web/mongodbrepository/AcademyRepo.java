package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.web.mongodbclass.Academy;

public interface AcademyRepo extends MongoRepository<Academy, String> {

	Academy findByName(String name);
	

}
