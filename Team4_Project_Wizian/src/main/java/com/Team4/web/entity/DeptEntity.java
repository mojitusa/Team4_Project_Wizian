package com.Team4.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "DEPT_CD")
public class DeptEntity {
	
	@Id
	@Column(name = "C_CD")
	private String cCd;

    @Column(name = "C_NMK")
	private String cNmk;
    
    @Column(name = "C_NME")
    private String cNme;
    
    @Column(name = "SE_NM")
    private String seName;
    
}
