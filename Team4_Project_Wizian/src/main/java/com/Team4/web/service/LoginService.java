package com.Team4.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.repository.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public boolean checkLogin(String userNo, String pw) {
		return loginDAO.checkLogin(userNo,pw);
	}

	public String getName(String id) {
		return loginDAO.getName(id);
	}
}
