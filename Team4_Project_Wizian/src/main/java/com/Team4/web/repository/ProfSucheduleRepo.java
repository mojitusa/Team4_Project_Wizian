package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Team4.web.entity.ProfSchedule;

public interface ProfSucheduleRepo extends JpaRepository<ProfSchedule, Integer> {

	@Query("SELECT u FROM PROFESSER_SCHEDULE u WHERE u.PF_NO = :PFNo")
	List<ProfSchedule> findByPF_NO(@Param("PFNo") String pfNo);
}
