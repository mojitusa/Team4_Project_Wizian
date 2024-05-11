package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.Department;
import com.Team4.web.entity.Employee;
import com.Team4.web.repository.JoinExamRepo;

@Service
public class JoinExamRepoService {

	@Autowired
	JoinExamRepo joinExamrepo;
	
	public List<Employee> doFindAll() {
		return joinExamrepo.findAll();
	}
	
	public List<Department> doFindAllDe() {
		return joinExamrepo.findAllDepartments();
	}
	
	
}
