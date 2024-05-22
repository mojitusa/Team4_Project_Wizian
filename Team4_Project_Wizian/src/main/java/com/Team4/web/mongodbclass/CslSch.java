package com.Team4.web.mongodbclass;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "csl_sch") // 실제 몽고 DB 컬렉션(테이블) 이름 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //빈으로 연결
public class CslSch{

	@DBRef
	private CounselorMongo counselor;
	
	private LocalDate open_date;
	private String time_cd;
	private String csl_time;
    private Boolean book;
    
}
