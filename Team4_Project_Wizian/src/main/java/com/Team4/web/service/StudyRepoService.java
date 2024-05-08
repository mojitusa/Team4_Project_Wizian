package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.Study;
import com.Team4.web.repository.StudyRepo;

@Service
public class StudyRepoService {

	@Autowired
	StudyRepo studyRepo;

	// 전체 행 가져오기
	public List<Study> doSelectAll() {
		return studyRepo.findAll();
	}

	// 행 하나 가져오기
	public Study doSelectOne(int Key_id) {
		return studyRepo.findById(1).get();
	}

	// 입력
	public void doInsert(Study study) {
		studyRepo.save(study);
	}

	// 업데이트
	public void doUpdate(Study study) {
		studyRepo.save(study);
	}

	// 삭제
	public void doDelete(int key_id) {
		studyRepo.deleteById(key_id);
	}

	
	//내가 만든 쿼리 사용
	public List<Study> doFindById(int id) {
		return studyRepo.findByKey_id(id); }
	
}
