package com.Team4.web.service;

import java.util.Map;

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

	public Map<String, Object> getName(String id) {
		return loginDAO.getName(id);
	}

	public Map<String, Object> getInfoPro(String userNo) {
		return loginDAO.getInfoPro(userNo);
	}

	public Map<String, Object> getInfoCounselor(String userNo) {
		return loginDAO.getInfoCounselor(userNo);
	}
}
