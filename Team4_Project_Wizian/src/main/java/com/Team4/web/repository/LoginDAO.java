package com.Team4.web.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;

@Repository
public class LoginDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	public boolean checkLogin(String userNo, String pw) {
	    Map<String, String> params = new HashMap<>();
	    params.put("userNo", userNo);
	    params.put("pw", pw);
	    int count = sqlSessionTemplate.selectOne("check", params);
	    return count > 0;
	}

	public Map<String, Object> getName(String userNo) {
	    return sqlSession.selectOne("getName", userNo);
	}

	public Map<String, Object> getInfoPro(String userNo) {
		return sqlSession.selectOne("getInfoPro",userNo);
	}

	public Map<String, Object> getInfoCounselor(String userNo) {
		System.out.println("dao동작확인");
		return sqlSession.selectOne("getInfoCounselor", userNo);
	}


}
