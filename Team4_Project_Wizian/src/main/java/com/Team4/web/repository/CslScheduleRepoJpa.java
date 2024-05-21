package com.Team4.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.CslScheduleEntity;
import com.Team4.web.entity.CslorEntity;

public interface CslScheduleRepoJpa extends JpaRepository<CslScheduleEntity, Integer>{

	List<CslScheduleEntity> findAllByCounselor(Optional<CslorEntity> byId);


}
