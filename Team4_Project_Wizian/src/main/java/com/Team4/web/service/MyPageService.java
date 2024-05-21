package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.repository.MyPageDAO;

@Service
public class MyPageService {

	@Autowired
	private MyPageDAO myPageDAO; 
	
	public int updatePrivacy(String phoneNumber, String email, String stud_no) {
		return myPageDAO.updatePrivacy(phoneNumber, email,stud_no);
	}

	public List<Inquiry> getAllBoard(String userNo) {
		return myPageDAO.getAllBoard(userNo);
	}

	
	
}
