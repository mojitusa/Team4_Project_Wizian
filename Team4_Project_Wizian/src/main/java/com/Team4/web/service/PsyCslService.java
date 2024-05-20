package com.Team4.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mongodbclass.PsyCslSurvey;
import com.Team4.web.mongodbclass.StudentMongo;
import com.Team4.web.entity.StudentEntity;
import com.Team4.web.mongodbrepository.PsyCslSurveyRepo;
import com.Team4.web.mongodbrepository.StudentRepoMongo;
import com.Team4.web.mongodbrepository.UsersRepo;

@Service
public class PsyCslService {
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	StudentRepoMongo studentRepo;
	
	@Autowired
	com.Team4.web.repository.StudentRepoJpa studentJpaRepo;
	
	@Autowired
	PsyCslSurveyRepo psyCslSurveyRepo;

	public StudentEntity getJpaStudentByUserNo(String userNo) {
		return studentJpaRepo.findById(userNo).get();
	}
	
	public StudentMongo fiundStudentByUserNo(String userNo) {
		return studentRepo.findByUsers(usersRepo.findByUserNo(userNo));
		
	}

	public void savePsyCslSurvey(PsyCslSurvey formData) {
		psyCslSurveyRepo.save(formData);
	}
	
	
}
