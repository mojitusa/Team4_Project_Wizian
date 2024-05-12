package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mongodbclass.Counselor;
import com.Team4.web.mongodbclass.TestClass;
import com.Team4.web.mongodbclass.Users;
import com.Team4.web.mongodbrepository.CounselorRepo;
import com.Team4.web.mongodbrepository.MongoDbRepo;
import com.Team4.web.mongodbrepository.UsersRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MongoDbService {
    
	@Autowired
    MongoDbRepo mRepo;
	
	@Autowired
	UsersRepo uRepo;
	
	@Autowired
	CounselorRepo counserlorRepo;
    
    public List<TestClass> getMdbClassByName(String name) {
        return mRepo.findByName(name);
    }
    
    public void setUsersClass(Users users) {
    	 uRepo.save(users);
    }
    
    public List<Users> getUsersClass() {
    	return uRepo.findAll();
    }
    
	public void setCounselorClass(Counselor counselor) {
		counserlorRepo.save(counselor);
	}

	public List<Counselor> getCounselor() {
		return counserlorRepo.findAll();
		
	}
    
}