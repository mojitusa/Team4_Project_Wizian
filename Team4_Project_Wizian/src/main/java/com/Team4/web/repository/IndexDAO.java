package com.Team4.web.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IndexDAO {

	@Autowired
	private SqlSession sqlSession;

	public int getCoun(int secd) {
		return sqlSession.selectOne("Mymapper.myStud", secd);
	}
	
	
}
