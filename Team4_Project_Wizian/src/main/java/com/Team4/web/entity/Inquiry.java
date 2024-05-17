package com.Team4.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Inquiry") // 테이블 이름. 없으면 클래스 명과 동일
public class Inquiry {
    @Id
    @Column(name = "CSL_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CSL_NO; 
    
    @Column(name = "STUD_NO")
    private String STUD_NO;
    
    @Column(name = "CSL_TITLE")
    private String CSL_TITLE;
    
    @Column(name = "CSL_EMAIL")
    private String CSL_EMAIL;
    
    @Column(name = "CSL_CONTENT")
    private String CSL_CONTENT;
    
    @Column(name = "CSL_ANSWER")
    private String CSL_ANSWER;
    
    @Column(name = "CSL_EVAL")
    private String CSL_EVAL;
    
    @Column(name = "CSL_CATEGORY")
    private String CSL_CATEGORY;
    
    @Column(name = "CSL_DATE")
    private Date CSL_DATE = new Date();
    
    @Column(name = "CSL_STATUS")
    // 접수상태 0: 접수중 , 1: 상담완료
    private int CSL_STATUS = 0;

	
    	
    
}