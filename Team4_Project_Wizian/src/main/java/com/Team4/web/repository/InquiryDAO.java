package com.Team4.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InquiryDAO {

	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> getCounselBoard(String category, String userNo) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("userNo", userNo);
        return sqlSession.selectList("getCounselBoard", params);
    }
	
}
