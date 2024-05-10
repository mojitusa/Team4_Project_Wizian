package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Team4.web.entity.Study;

public interface StudyRepo extends JpaRepository<Study, Integer> {

	//JPQL 사용
	@Query("select s from Study s where s.key_id = :id")
	List<Study> findByKey_id(@Param("id") int id);
}
