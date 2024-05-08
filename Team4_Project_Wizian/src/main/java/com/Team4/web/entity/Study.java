package com.Team4.web.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "study_member") // 테이블 이름. 없으면 클래스 명과 동일
public class Study {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 오토 인크리먼트
	private int key_id;
	
	@Column(name = "study_day")
	private String study_day;
	
	@Column(name = "contents")
	private String contents;
	
    @Column(name = "reg_day")
    private LocalDateTime regDay = LocalDateTime.now(); // 필드 이름을 reg_day가 아니라 regDay로 변경
	

}
