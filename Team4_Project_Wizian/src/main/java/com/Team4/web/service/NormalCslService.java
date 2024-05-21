package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.CslorEntity;
import com.Team4.web.repository.CounselorRepoJpa;

@Service
public class NormalCslService {
	
	@Autowired
	CounselorRepoJpa counselorRepo;

	public List<CslorEntity> getJpaCounselorByCareer() {
		
		return counselorRepo.findAllByCareer("1");
	}
	
	// 페이징 기능 추가
	public Page<CslorEntity> getJpaCounselorByCareer(Pageable pageable) {
		return counselorRepo.findAllByCareer("1", pageable);
	}
	
	
}
