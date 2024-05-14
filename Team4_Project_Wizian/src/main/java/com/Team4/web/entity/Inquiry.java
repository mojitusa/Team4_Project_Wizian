package com.Team4.web.entity;

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
@Table(name = "CSL_BOARD") // 테이블 이름. 없으면 클래스 명과 동일
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CSL_NO; 
       
    private String STUD_NO;
    private String CSL_TITLE;
    private String CSL_EMAIL;
    private String CSL_CONTENT;
    private String CSL_ANSWER;
    private String CSL_EVAL;
    private String CSL_CATEGORY;
    private Date CSL_DATE = new Date();
}