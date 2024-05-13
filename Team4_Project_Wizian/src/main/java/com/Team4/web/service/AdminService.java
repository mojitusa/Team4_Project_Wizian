package com.Team4.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.repository.AdminDAO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	public void studSignUp(String studentGender, String studentName, String studentDept, String studentContact,
			String studentEmail, String studentPw) {
		adminDAO.studSignUp(studentGender, studentName, studentDept, studentContact, studentEmail, studentPw);
	}
	
	
}
