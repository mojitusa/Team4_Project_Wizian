package com.Team4.web.mongodbclass;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.Team4.web.entity.CslorEntity;
import com.Team4.web.entity.StudentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "csl_apply") // 실제 몽고 DB 컬렉션(테이블) 이름 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //빈으로 연결
public class CslApplyMongo {
	
	@Id
	private String id;
	
	@DBRef
	private StudentEntity student;
	
	@DBRef
	private CslorEntity counselor;
	
	@DBRef
	private CslSch cslSch;
	
	private String cate;
	private String studentName;
	private String studNo;
	private String deptName;
	private String studentTelNo;
	private String studentEmail;
	private String date;
	private String time;
	private String isbook;
	private String schNo;
	private String cslorName;
	private String cslorNo;
	private String cslLoc;
	private String cslApplyText;
	private int attachmentNo;
    
    //이하는 심리상담에만 해당하는 요소
    private Date SecretAgree;
    private Date personalInfoAgree;
    private Date delicaFormDatateInfoAgree;
    

}
