package com.Team4.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Team4.web.model.BoardModel;

@Repository
public class BoardDAO {

	@Autowired SqlSession sqlSession;

	public List<BoardModel> boardList() {
		return sqlSession.selectList("board.boardList");
	}
	
	
}
