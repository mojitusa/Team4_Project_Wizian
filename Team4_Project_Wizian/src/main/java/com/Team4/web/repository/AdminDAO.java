package com.Team4.web.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSession sqlSession;

	public void studSignUp(String studentGender, String studentName, String studentDept, String studentContact,
			String studentEmail, String studentPw) {
		String statement = "insertStudent";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("studentGender", studentGender);
		parameters.put("studentName", studentName);
		parameters.put("studentDept", studentDept);
		parameters.put("studentContact", studentContact);
		parameters.put("studentEmail", studentEmail);
		parameters.put("studentPw", studentPw);

		sqlSession.insert(statement, parameters);
		sqlSession.insert(statement, parameters);
		sqlSession.insert(statement, parameters);
	}
}
