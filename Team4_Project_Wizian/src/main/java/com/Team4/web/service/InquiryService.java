package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.repository.InquiryRepository;

@Service
public class InquiryService {
	private final InquiryRepository inquiryRepository;
	
	@Autowired
	public InquiryService(InquiryRepository inquiryRepository) {
		this.inquiryRepository = inquiryRepository;
	}

	public List<Inquiry> getAllInquiries() {
		return inquiryRepository.findAll();
	}

	public void saveInquiry(Inquiry inquiry) {
		inquiryRepository.save(inquiry);
		
	}

	public Inquiry findById(int id) {
        return inquiryRepository.findById(id).orElse(null);
    }
}
