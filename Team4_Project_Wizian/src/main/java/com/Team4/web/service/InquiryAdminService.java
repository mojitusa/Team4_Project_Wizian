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

	public InquiryAdmin getInquiryById(Integer id) {
		return inquiryAdminRepo.findById(id).orElse(null);
	}
}