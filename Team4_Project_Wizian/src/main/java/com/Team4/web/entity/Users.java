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
@Table(name = "USERS")
public class Users {
	
	@Id
	@Column(name = "user_no")
	private String userno;
	
	private String se_cd;
	
	private Integer no;
	
	private String pw;
	
	private String frst_reg_tm;
	
	private String email;

}
