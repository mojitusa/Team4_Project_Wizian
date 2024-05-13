package com.Team4.web.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROFESSER")
public class Professer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String PF_NO;
	
	@Column(length = 11)
	private String PF_TELNO;
	
	@Column(length = 1000)
	private String PF_CS_PART;
	
	@Column(length = 4000)
	private String PF_CS_PART_DETAIL;
	
	@Column(length = 100)
	private String PF_PLC_NM;
	
	@Column
	private String C_CD;
	
	@Column(length = 10)
	private String USER_NO;
	
	@OneToMany(mappedBy = "professer")
	private Set<ProfSchedule> profSchedules;
	
}
