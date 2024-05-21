package com.Team4.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Map<String, Object> getStudInfo(String userNo) {
		return myPageDAO.getStudInfo(userNo) ;
	}

	public boolean checkPassword(String originalPassword, String userNo) {
		return myPageDAO.checkPassword(originalPassword, userNo);
	}

	public int updatePw(String newPassword, String userNo) {
		Map<String, Object> parameters = new HashMap<>();
		System.out.println(newPassword);
	    parameters.put("password", newPassword);
	    parameters.put("userNo", userNo);
	    System.out.println("vkfk" + parameters);
		return myPageDAO.updatePw(parameters);
	}

	
	
}
