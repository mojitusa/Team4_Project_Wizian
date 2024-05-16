package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

	public int getBoardCount(@RequestParam("stud_no") String studNo ) {
		return inquiryRepository.countByStud_no(studNo);
	}

}
