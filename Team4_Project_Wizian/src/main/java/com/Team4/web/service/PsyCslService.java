package com.Team4.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mongodbclass.PsyCslSurvey;
import com.Team4.web.mongodbclass.Student;
import com.Team4.web.mongodbrepository.PsyCslSurveyRepo;
import com.Team4.web.mongodbrepository.StudentRepo;
import com.Team4.web.mongodbrepository.UsersRepo;
import com.Team4.web.repository.UserRepo;

@Service
public class PsyCslService {
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	PsyCslSurveyRepo psyCslSurveyRepo;

	public Student getStudentByUserNo(String userNo) {
		return studentRepo.findByUsers(usersRepo.findByUserNo(userNo));
		
	}

	public void savePsyCslSurvey(PsyCslSurvey formData) {
		psyCslSurveyRepo.save(formData);
	}
	
	
}
