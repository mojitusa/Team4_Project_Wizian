package com.Team4.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private String user_no;
	
	private String se_cd;
	
	private String no;
	
	private String pw;
	
	private String frst_reg_tm;
	
	private String user_cd;
	
	private String email;

}
