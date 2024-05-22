package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.CounselorMongo;
import com.Team4.web.mongodbclass.UsersMongo;

public interface CounselorRepo extends MongoRepository<CounselorMongo, String>{

	@Query("{'csl_loc': ?0}")
	CounselorMongo findByCslLoc(String cslLoc);
    
    // users 필드를 기반으로 Counselor를 검색
	CounselorMongo findByUsers(UsersMongo users);
    
}