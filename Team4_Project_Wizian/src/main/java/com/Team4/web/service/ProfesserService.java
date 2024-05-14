package com.Team4.web.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.ProfSchedule;
import com.Team4.web.entity.Professer;
import com.Team4.web.repository.ProfDataRepo;
import com.Team4.web.repository.ProfSucheduleRepo;


@Service
public class ProfesserService {

	@Autowired
	private ProfSucheduleRepo profSucheduleRepo;
	private ProfDataRepo profDataRepo;
	
	public List<ProfSchedule> getProfSchedules(String pfNo){
		return profSucheduleRepo.findByPFNo(pfNo);
	}

	public List<Professer> getProfData(String pfNo) {
		return profDataRepo.findByProfId(pfNo);
	}
}
