package com.Team4.web.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Team4.web.entity.Inquiry;

@Repository
public interface InquiryRepo extends JpaRepository<Inquiry, Integer> {
}