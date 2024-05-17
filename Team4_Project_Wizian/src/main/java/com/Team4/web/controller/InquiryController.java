package com.Team4.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.model.BoardModel;
import com.Team4.web.repository.BoardDAO;
import com.Team4.web.service.InquiryService;
import com.Team4.web.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class InquiryController {

	private final InquiryService inquiryService;
	
    @Autowired
    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

	@Autowired
	private Util util;

	@Autowired
	private BoardDAO boardDAO;
	@GetMapping("/inquiry")
	public ModelAndView InquiryPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiry"); // inquiry.html 파일로 매핑
		System.out.println("통과확인");
		// 다른 모델 데이터 추가 가능
		return modelAndView;
	}

	@PostMapping("/inquiry")
	public String submitInquiry(@ModelAttribute Inquiry inquiry, RedirectAttributes redirectAttributes) {
		try {
			inquiryService.saveInquiry(inquiry);
			redirectAttributes.addFlashAttribute("성공");
			return "redirect:/receptioncomplete";
		} catch (Exception e) {
			return "error";
		}
	}
	
//	@GetMapping("/inquiryhistory")
//	public List<BoardModel> inquiryHistory(){
//		List<BoardModel> boardList = boardDAO.boardList();
//		System.out.println(boardList);
//		return boardList;
//	}
//	@GetMapping("/inquiryhistory")
//    public ModelAndView inquiryHistory() {
//        ModelAndView modelAndView = new ModelAndView("inquiryhistory");
//
//        List<Inquiry> inquiries = inquiryService.getAllInquiries();
//        modelAndView.addObject("inquiries", inquiries);
//        System.out.println(inquiries);
//        return modelAndView;
//    }

    @GetMapping("/inquiryhistory/json")
    @ResponseBody
    public Map<String, Object> inquiryHistoryJson() {
        List<Inquiry> inquiries = inquiryService.getAllInquiries();
        System.out.println(inquiries);
        Map<String, Object> response = new HashMap<>();
        response.put("inquiries", inquiries);

        return response;
    }
	
//	@GetMapping("/inquiryhistory")
//	@ResponseBody
//	public List<Inquiry> inquiryHistory() {
//	    
//	    List<Inquiry> inquiries = inquiryService.getAllInquiries();
//	    System.out.println("동작확인" + inquiries);
//	    return inquiries;
//	}

	@GetMapping("/inquiry/detail/{id}")
	public ModelAndView showInquiryDetail(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiryCsl"); // 상담사가 확인하는 페이지 
//		Inquiry inquiry = inquiryService.findById(id);
//		if (inquiry != null) {
//			modelAndView.addObject("inquiry", inquiry);
//			modelAndView.setViewName("inquirydetail");
//		} else {
//			modelAndView.setViewName("error");
//		}
		// inquiryId를 사용하여 해당 문의의 상세 정보를 조회
		Inquiry inquiry = inquiryService.getInquiryById(inquiryId);
		modelAndView.addObject("inquiry", inquiry);

		return modelAndView;
	}

}
