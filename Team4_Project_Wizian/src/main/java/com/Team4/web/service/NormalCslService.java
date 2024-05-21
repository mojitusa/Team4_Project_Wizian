package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.CslScheduleEntity;
import com.Team4.web.entity.CslorEntity;
import com.Team4.web.repository.CounselorRepoJpa;
import com.Team4.web.repository.CslScheduleRepoJpa;

@Service
public class NormalCslService {
	
	@Autowired
	CounselorRepoJpa counselorRepo;
	
	@Autowired
	CslScheduleRepoJpa cslScheduleRepo;

	public List<CslorEntity> getJpaCounselorByCareer() {
		
		return counselorRepo.findAllByCareer("1");
	}
	
	// 페이징 기능 추가
	public Page<CslorEntity> getJpaCounselorByCareer(Pageable pageable) {
		return counselorRepo.findAllByCareer("1", pageable);
	}

	public List<CslorEntity> getJpaCslorByGender() {
		return counselorRepo.findAllByGender("1");
	}

	public List<CslScheduleEntity> getJpaCslSchduleByCounselor() {
		return cslScheduleRepo.findAllByCounselor(counselorRepo.findById("1300000014"));
	}
	
	
}
