package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Team4.web.entity.Professer;

public interface ProfDataRepo extends JpaRepository<Professer, String>{

	@Query("SELECT p FROM Professer p WHERE p.id = :id")
	List<Professer> findByProfId(@Param("id") String pfNo);

}
