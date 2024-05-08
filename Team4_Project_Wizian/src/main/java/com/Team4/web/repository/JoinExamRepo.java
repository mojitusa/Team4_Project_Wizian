package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Team4.web.entity.Employee;
import com.Team4.web.entity.Study;

public interface JoinExamRepo extends JpaRepository<Employee, Long>{

	//JPQL 사용
	@Query("select e from Emplyee e join e.department d")
	List<Study> findByKey_id(@Param("id") int id);	
}
