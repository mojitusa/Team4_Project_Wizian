package com.Team4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.service.InquiryService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InquiryController {
	
	private final InquiryService inquiryService;
	
	@Autowired
	public InquiryController(InquiryService inquiryService) {
		this.inquiryService = inquiryService;
	}
	
	@GetMapping("/inquiry")
    public ModelAndView InquiryPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inquiry"); // inquiry.html 파일로 매핑
        // 다른 모델 데이터 추가 가능
        return modelAndView;
    }
	
	@PostMapping("/inquiry")
	public String submitInquiry(@ModelAttribute Inquiry inquiry, RedirectAttributes redirectAttributes) {
	    try {
	        inquiryService.saveInquiry(inquiry);
	        redirectAttributes.addFlashAttribute("성공");
	        return "redirect:/receptioncomplete.html"; // 저장 성공 시 리다이렉트
	    } catch (Exception e) {
	        return "error"; // 저장 실패 시 에러 페이지로 이동
	    }
	}
   
	
	@GetMapping("/inquiry/history")
	public ModelAndView InquiryHistory(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiryhistory");
		
		List<Inquiry> inquiries = inquiryService.getAllInquiries();
		modelAndView.addObject("inquiries", inquiries);
		
		return modelAndView;
	}
	
	@GetMapping("/inquiry/history/detail/{id}") // URL을 "/inquiry/history/detail/{id}"로 설정
    public ModelAndView showInquiryDetail(@PathVariable("id") int inquiryId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inquirydetail"); // inquirydetail.html로 매핑

        // inquiryId를 사용하여 해당 문의의 상세 정보를 조회
        Inquiry inquiry = inquiryService.getInquiryById(inquiryId);
        modelAndView.addObject("inquiry", inquiry);

        return modelAndView;
    }
	
	@GetMapping("/inquiry/{id}/detail")
	public ModelAndView showInquiryDetailForAgent(@PathVariable("id") int inquiryId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiryCsl"); // 상담사가 확인하는 페이지 

		// inquiryId를 사용하여 해당 문의의 상세 정보를 조회
		Inquiry inquiry = inquiryService.getInquiryById(inquiryId);
		modelAndView.addObject("inquiry", inquiry);

		return modelAndView;
	}
	
	@PostMapping("/inquiry/response")
    public String submitResponse(@ModelAttribute Inquiry inquiry) {
        try {
            // 상담사가 작성한 답변을 DB에 저장
            inquiryService.saveResponse(inquiry.getCSL_NO(), inquiry.getCSL_ANSWER());

            // 해당 문의의 상태를 상담완료(1)로 업데이트
            inquiryService.updateInquiryStatus(inquiry.getCSL_NO(), 1);

            return "redirect:/inquiry/history"; // 답변 작성 성공 시 리다이렉트
        } catch (Exception e) {
            return "error"; // 답변 작성 실패 시 에러 페이지로 이동
        }
    }
	
	

}
