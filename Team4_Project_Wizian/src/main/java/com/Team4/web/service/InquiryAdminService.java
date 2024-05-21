package com.Team4.web.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.InquiryAdmin;
import com.Team4.web.repository.InquiryAdminRepo;

@Service
public class InquiryAdminService {

    private final InquiryAdminRepo inquiryAdminRepo;

    @Autowired
    public InquiryAdminService(InquiryAdminRepo inquiryAdminRepo) {
        this.inquiryAdminRepo = inquiryAdminRepo;
    }

    public List<InquiryAdmin> getAllInquiries() {
        return inquiryAdminRepo.findAll(); 
    }
    
 // 답변 작성 및 상태 업데이트 메서드
    public void saveResponseAndComplete(int inquiryId, String response) {
        InquiryAdmin inquiry = inquiryAdminRepo.findById(inquiryId).orElse(null);
        if (inquiry != null) {
            inquiry.setCSL_ANSWER(response); // 답변 저장
            inquiry.setIN_STATUS("상담 완료"); // 상태 업데이트
            inquiryAdminRepo.save(inquiry);
        }
    }

}