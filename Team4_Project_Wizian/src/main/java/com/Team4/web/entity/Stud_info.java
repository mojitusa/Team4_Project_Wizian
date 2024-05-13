package com.Team4.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Stud_info {
	
	@Id
	private String STUD_NO;
	
	private String MTCLTN_YMD;
	
	private Integer no;
	
	private String ST;
	
	private String C_CD;
	
	private String USER_NO;
	
	private String STUD_NM;

}
