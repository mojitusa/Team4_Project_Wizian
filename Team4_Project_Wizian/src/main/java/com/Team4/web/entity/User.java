package com.Team4.web.entity;

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
@Table(name = " USERS") // 테이블 이름. 없으면 클래스 명과 동일
public class User {
	
	@Id
	private String user_no;
	
	private String se_cd;
	
	private Integer no;
	
	private String pw;
	
	private String frst_reg_tm;
	
	private String email;

}
