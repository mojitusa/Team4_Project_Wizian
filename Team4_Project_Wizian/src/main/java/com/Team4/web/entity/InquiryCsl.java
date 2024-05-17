package com.Team4.web.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "InquiryCsl") // 테이블 이름. 없으면 클래스 명과 동일
public class InquiryCsl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CSL_NO;         
    private String IN_REPLY;
    private String IN_STATUS;
    
    private String STUD_NO; // STUD_NO 속성 추가
    private String CSL_EMAIL;
    private String CSL_CONTENT;
    private String CSL_ANSWER;
    private String CSL_EVAL;
    private String CSL_CATEGORY;
    private String CSL_TITLE;
    private Date CSL_DATE = new Date();
    
    @OneToOne // Inquiry 테이블과 일대일 관계 설정
    @JoinColumn(name = "CSL_NO") // 외래 키로 조인할 열 지정
    private Inquiry inquiry; // Inquiry 엔터티와 연결
    
}