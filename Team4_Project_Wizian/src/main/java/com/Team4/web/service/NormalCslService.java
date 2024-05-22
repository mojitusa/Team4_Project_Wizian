package com.Team4.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.CslScheduleEntity;
import com.Team4.web.entity.CslorEntity;
import com.Team4.web.entity.StudentEntity;
import com.Team4.web.mongodbclass.CslApplyMongo;
import com.Team4.web.mongodbrepository.CslApplyRepoMongo;
import com.Team4.web.repository.CounselorRepoJpa;
import com.Team4.web.repository.CslScheduleRepoJpa;
import com.Team4.web.repository.StudentRepoJpa;

@Service
public class NormalCslService {
	
	@Autowired
	CounselorRepoJpa counselorRepoJpa;
	
	@Autowired
	CslScheduleRepoJpa cslScheduleRepo;
	
	@Autowired
	StudentRepoJpa studentRepoJpa;
	
	@Autowired
	CslApplyRepoMongo cslApplyRepoMongo;

	public List<CslorEntity> getJpaCounselorByCareer() {
		
		return counselorRepoJpa.findAllByCate("1");
	}
	
	// 페이징 기능 추가
	public Page<CslorEntity> getJpaCounselorByCareer(Pageable pageable) {
		return counselorRepoJpa.findAllByCate("1", pageable);
	}

	public List<CslorEntity> getJpaCslorByGender() {
		return counselorRepoJpa.findAllByCate("2");
	}

	public List<CslScheduleEntity> getJpaCslSchduleByCounselor(String cslNo) {
		return cslScheduleRepo.findAllByCounselor(counselorRepoJpa.findById(cslNo));
	}

	public void saveCslApply(CslApplyMongo cslApply) {
		cslApplyRepoMongo.save(cslApply);
		CslScheduleEntity schedule = cslScheduleRepo.findById(Integer.parseInt(cslApply.getSchNo())).orElse(null);
		schedule.setIsbook("5");
		cslScheduleRepo.save(schedule);
	}
	
	
}
