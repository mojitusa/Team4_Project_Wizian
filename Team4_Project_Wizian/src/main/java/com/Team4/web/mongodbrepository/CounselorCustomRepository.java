package com.Team4.web.mongodbrepository;

import com.Team4.web.mongodbclass.Counselor;

public interface CounselorCustomRepository {
	
	Counselor findByUsersUserNo(String userNo);

}
