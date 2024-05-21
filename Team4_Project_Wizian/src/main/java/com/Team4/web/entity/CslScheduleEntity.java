package com.Team4.web.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "CSL_SCH")
public class CslScheduleEntity {
	
	@Id
	@Column(name = "SCH_NO")
	private int no;
	
    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private CslorEntity counselor;

	@Column(name = "OPEN_DATE")
	private LocalDate date;
	
	@Column(name = "CSL_TIME_CD")
	private LocalTime time;
	
    @Column(name = "BOOK")
    private String isbook;

}
