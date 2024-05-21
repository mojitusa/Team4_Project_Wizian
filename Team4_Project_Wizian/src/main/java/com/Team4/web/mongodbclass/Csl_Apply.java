package com.Team4.web.mongodbclass;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "csl_apply") // 실제 몽고 DB 컬렉션(테이블) 이름 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //빈으로 연결
public class Csl_Apply {
	
	@Id
	private String id;
	
	@DBRef
	private StudentMongo student;
	
	@DBRef
	private CslSch cslSch;
	
	private String preCslNo;
	private String CslCateCd;
	private String cslState;
	private int online;
	private int onlineCslCd;
    private String CslApplyContent;
    
    //이하는 심리상담에만 해당하는 요소
    private Date SecretAgree;
    private Date personalInfoAgree;
    private Date delicaFormDatateInfoAgree;
    

}
