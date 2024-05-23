package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.CounselorMongo;
import com.Team4.web.mongodbclass.CslApplyMongo;
import com.Team4.web.mongodbclass.UsersMongo;

public interface CslApplyRepoMongo extends MongoRepository<CslApplyMongo, String>{

}
