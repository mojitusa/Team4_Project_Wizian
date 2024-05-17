package com.Team4.web.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.Inquiry;

public interface PagingRepository extends JpaRepository<Inquiry, Integer> {
}