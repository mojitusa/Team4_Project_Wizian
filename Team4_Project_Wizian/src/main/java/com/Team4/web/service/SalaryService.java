package com.Team4.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.mapper.SalaryMapper;
import com.Team4.web.model.SalaryModel;

@Service
public class SalaryService {
	@Autowired
	public SalaryMapper mapper;
	
	public List<SalaryModel> getSalary(){
		return mapper.getSalary();
	}
}
