package com.Team4.web.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.InquiryAdmin;


@Repository
public interface InquiryAdminRepo extends JpaRepository<InquiryAdmin, Integer> {
	
}
