package com.Team4.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.repository.IndexDAO;

@Service
public class IndexService {
	@Autowired
	private IndexDAO indexDao;

	public int getCoun(int secd) {
		return indexDao.getCoun(secd);
	}
	
	
}
