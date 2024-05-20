package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Team4.web.mongodbclass.PsyCslSurvey;

public interface PsyCslSurveyRepo extends MongoRepository<PsyCslSurvey, String>{
	
}