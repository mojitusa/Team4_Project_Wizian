package com.Team4.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Team4.web.model.BoardModel;

@Repository
public class BoardDAO {

	@Autowired SqlSession sqlSession;

	public List<BoardModel> boardList(Object session) {
		return sqlSession.selectList("board.boardList", session);
	}

	public List<Map<String, Object>> getCounselDetail(int cslNo, String category) {
		Map<String, Object> parameters = new HashMap<>();
	    parameters.put("CSL_NO", cslNo);
	    parameters.put("category", category);
		return sqlSession.selectList("Mymapper.getCounselDetail", parameters);
	}
	
	
}
