package com.Team4.web.entity;

import java.util.Date;

import jakarta.persistence.Column;
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
public class InquiryAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSL_NO")
    private int CSL_NO;
    
    @Column(name = "IN_REPLY")
    private String IN_REPLY;
    
    @Column(name = "IN_STATUS")
    private String IN_STATUS;
    
    @Column(name = "STUD_NO")
    private String STUD_NO;
    
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
    
    @Column(name = "CSL_TITLE")
    private String CSL_TITLE;
    
    @Column(name = "CSL_DATE")
    private Date CSL_DATE = new Date();
    
    @OneToOne
    @JoinColumn(name = "CSL_NO")
    private Inquiry inquiry;
}