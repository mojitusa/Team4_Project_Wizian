package com.Team4.web.mongodbclass;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "academy_student") // 실제 몽고 DB 컬렉션(테이블) 이름 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //빈으로 연결
public class AcademyStudent{
	

//    @Id
//    private String id; // 몽고DB의 _id와 매핑될 필드

	private String name;
    private int age;
    
    @DBRef
    private Academy academy;
    
}
