package com.Team4.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Team4.web.entity.Inquiry;

@Repository
public class MyPageDAO {

	@Autowired
	private SqlSession sqlSession;

	public int updatePrivacy(String phoneNumber, String email, String stud_no) {
		Map<String, Object> parameters = new HashMap<>();
	    parameters.put("phoneNumber", phoneNumber);
	    parameters.put("email", email);
	    parameters.put("studNo", stud_no);
		return sqlSession.update("updatePrivacy", parameters);
	}

	public List<Inquiry> getAllBoard(String userNo) {
		return sqlSession.selectList("getAllBoard",userNo);
	}

	public Map<String, Object> getStudInfo(String userNo) {
		return sqlSession.selectOne("Mymapper.getStudInfo", userNo);
	}

	public boolean checkPassword(String originalPassword, String userNo) {
		Map<String, Object> parameters = new HashMap<>();
	    parameters.put("password", originalPassword);
	    parameters.put("userNo", userNo);
		
		return sqlSession.selectOne("checkPw", parameters);
	}

	public int updatePw(Map<String, Object> parameters) {
		
		return sqlSession.update("updatePw", parameters);
	}
	
}
