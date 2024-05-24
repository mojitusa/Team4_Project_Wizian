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
@Table(name = "CSL_APPLY")
public class CslApplyEntity {
	
	@Id
	@Column(name = "CSL_NO")
	private int cslNo;

	@Column(name = "CSL_CATE_CD")
	private String cate;
    
    @ManyToOne
    @JoinColumn(name = "STUD_NO")
    private StudentEntity student;
    
    @ManyToOne
    @JoinColumn(name = "CSLOR_NO")
    private CslorEntity counselor;
    
    @ManyToOne
    @JoinColumn(name = "SCH_NO")
    private CslScheduleEntity cschedule;
    
    @Column(name = "CSL_STAT_CD")
    private String stat;
    
    @Column(name = "CSL_APL_DETAIL")
    private String cslDetail;

    
}
