package com.Team4.web.mongodbclass;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "psy_csl_survey") // 실제 몽고 DB 컬렉션(테이블) 이름 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component //빈으로 연결
public class PsyCslSurvey {
	
	@Id
	private String id;
	
    private String studentName;
    private String studentNo;
    private String studentBirth;
    private String studentcCd;
    private String student_st;
    private String mil;
    private String rel;
    private String phoneNumber;
    private String email;
    private String purposeEtc;
    private String routeEtc;
    private String exp;
    private String expdate;
    private String expLoc;
    private String psyTestEtc;
    private String personalSubjectEtc;
    private String groupSubjectEtc;
    private List<String> selectedCheckboxes;
    private List<PsyReservation> reservation;
    private List<EmergencyContact> emergencyContacts;

}
