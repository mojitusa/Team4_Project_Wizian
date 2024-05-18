package com.Team4.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mapper.ProfCslInsertMapper;
import com.Team4.web.model.ProfCslInsertModel;


@Service
public class ProfCslInsertService {

	@Autowired
	private ProfCslInsertMapper profCslInsertMapper;
	
	public void insertProfCslData(ProfCslInsertModel profCslInsertModel) {
		profCslInsertMapper.insertProfCslData(profCslInsertModel);
	}

	
}
