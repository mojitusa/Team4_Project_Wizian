package com.Team4.web.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Team4.web.entity.Inquiry;

@Repository
public interface InquiryRepo extends JpaRepository<Inquiry, Integer> {
	//JPQL 사용
	@Query("SELECT COUNT(*) FROM Inquiry WHERE STUD_NO = :STUD_NO")
	int countByStud_no(@Param("STUD_NO") String STUD_NO);
}
