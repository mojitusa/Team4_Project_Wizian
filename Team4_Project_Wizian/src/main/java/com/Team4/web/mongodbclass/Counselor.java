package com.Team4.web.mongodbclass;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "counselor") // 실제 몽고 DB 컬렉션(테이블) 이름 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //빈으로 연결
public class Counselor{

	@DBRef
	private Users user;
	
	private String c_cd;
    private String csl_loc;
    private int non_face;
    private int chat;
    private String csl_detail;
    
}
