package com.Team4.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.model.FileModel;
import com.Team4.web.repository.FileUploadDAO;
import com.Team4.web.util.Util;

@Service
public class FileUploadService {

	@Autowired
	private FileUploadDAO fileUploadDAO;
	
	@Autowired
	private Util util;
	
	public int FileInsert(FileModel dto) {
		//세션 추가
		if (util.getSession().getAttribute("username") != null) {
			return fileUploadDAO.FileInsert(dto);
		} else {
			return 0;
		}
	}
}
