package com.Team4.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PROFESSER_SCHEDULE")
public class ProfSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PF_SCD_NO;
	
	@Column(length=8)
	private String PF_SCD_YMD;
	
	@Column(length=5)
	private String PF_SCD_HMCD;
	
	@Column(length=100)
	private String PF_SCD_NM;
	
	@ManyToOne
	@JoinColumn(name = "PF_NO")
	private Professer professer;
	
	
}
