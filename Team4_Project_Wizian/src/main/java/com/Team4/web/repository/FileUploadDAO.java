package com.Team4.web.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Team4.web.model.FileModel;

@Repository
public class FileUploadDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public int FileInsert(FileModel dto) {
		return sqlSession.insert("file.fileInsert", dto);
	}
	
	
}
