package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Team4.web.entity.ProfSchedule;

public interface ProfSucheduleRepo extends JpaRepository<ProfSchedule, Integer> {

	@Query("SELECT p FROM ProfSchedule p JOIN p.professer d WHERE d.PF_NO= :PFNo")
	List<ProfSchedule> findByPFNo(@Param("PFNo") String PFNo);
}
