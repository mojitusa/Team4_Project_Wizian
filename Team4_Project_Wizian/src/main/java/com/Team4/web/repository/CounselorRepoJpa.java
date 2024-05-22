package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.CslorEntity;

public interface CounselorRepoJpa extends JpaRepository<CslorEntity, String>{

	
	List<CslorEntity> findAllByCate(String string);
    // 페이징 기능 추가
	Page<CslorEntity> findAllByCate(String string, Pageable pageable);




}
