package com.Team4.web.mongodbrepository;

import com.Team4.web.mongodbclass.CounselorMongo;

public interface CounselorCustomRepository {
	
	CounselorMongo findByUsersUserNo(String userNo);

}
