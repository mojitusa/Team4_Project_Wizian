package com.Team4.web.mongodbrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Team4.web.mongodbclass.Counselor;
import com.Team4.web.mongodbclass.UsersMongo;

public interface CounselorRepo extends MongoRepository<Counselor, String>{

	@Query("{'csl_loc': ?0}")
	Counselor findByCslLoc(String cslLoc);
    
    // users 필드를 기반으로 Counselor를 검색
    Counselor findByUsers(UsersMongo users);
    
}
