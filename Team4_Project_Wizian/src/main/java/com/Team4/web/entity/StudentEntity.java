package com.Team4.web.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "STUD_INFO")
public class StudentEntity {
    
    @Id
    @Column(name = "STUD_NO")
    private String userNoInStudent;
    
    @OneToOne
    @JoinColumn(name = "STUD_NO", referencedColumnName = "STUD_NO", insertable = false, updatable = false)
    private UsersEntity users;

    @Column(name = "REAL_STUD_NO")
    private String studNo;
    
    @Column(name = "ST")
    private String st;
    
    @ManyToOne
    @JoinColumn(name = "C_CD")
    private DeptEntity department;
                
    @Column(name = "STUD_NM")
    private String name;
    
    @Column(name = "GEN_CD")
    private String genCd;
    
    @Column(name = "ADDRKORN_ROAD_NM")
    private String address;
    
    @Column(name = "MBR_TELNO")
    private String telNo;
    
    @Column(name = "PF_NO")
    private String profNo;
    
    @Column(name = "BIRTHDAY")
    private String birth;
    
    @Column(name = "N_CD")
    private String nationCd;
}