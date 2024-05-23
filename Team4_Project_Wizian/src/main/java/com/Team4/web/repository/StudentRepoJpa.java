package com.Team4.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.StudentEntity;

public interface StudentRepoJpa extends JpaRepository<StudentEntity, String>{

	StudentEntity findByStudNo(String studNo);

}
