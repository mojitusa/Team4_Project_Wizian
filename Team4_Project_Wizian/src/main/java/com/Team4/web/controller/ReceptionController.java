package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.service.InquiryService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReceptionController {
	
	private final InquiryService inquiryService;
	
	public ReceptionController(InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}

    @PostMapping("/receptioncomplete")
    public ModelAndView completeReception(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("receptioncomplete"); // receptioncomplete.html 파일로 매핑
        
        String studNo = request.getParameter("STUD_NO");
        String cslEmail = request.getParameter("CSL_EMAIL");
        String cslCategory = request.getParameter("CSL_CATEGORY");
        String cslTitle = request.getParameter("CSL_TITLE");
        String cslContent = request.getParameter("CSL_CONTENT");
        
        Inquiry inquiry = new Inquiry();
        inquiry.setSTUD_NO(studNo);
        inquiry.setCSL_EMAIL(cslEmail);
        inquiry.setCSL_CATEGORY(cslCategory);
        inquiry.setCSL_TITLE(cslTitle);
        inquiry.setCSL_CONTENT(cslContent);
        inquiry.setCSL_STATUS("답변대기중");
        
        inquiryService.saveInquiry(inquiry);
        
        return modelAndView;
    }
}
