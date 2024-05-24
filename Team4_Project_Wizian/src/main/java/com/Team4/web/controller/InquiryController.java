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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView InquiryPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiry"); // inquiry.html 파일로 매핑
		
        String studNo = (String) session.getAttribute("userNo");
        modelAndView.addObject("studNo", studNo);
        
		return modelAndView;
	}
	@PostMapping("/inquiry")
	public String submitInquiry(@ModelAttribute Inquiry inquiry, HttpSession session, RedirectAttributes redirectAttributes) {
		try {
			String studNo = (String) session.getAttribute("userNo");
            inquiry.setSTUD_NO(studNo);
			inquiryService.saveInquiry(inquiry);
			redirectAttributes.addFlashAttribute("성공");
			return "redirect:/receptioncomplete";
		} catch (Exception e) {
			return "error";
		}
	}

    @GetMapping("/inquiryhistory/json")
    @ResponseBody
    public Map<String, Object> inquiryHistoryJson() {
        List<Inquiry> inquiries = inquiryService.getAllInquiries();
        System.out.println("inquiryhistoryjson동작확인1" + inquiries);
        Map<String, Object> response = new HashMap<>();
        response.put("inquiries", inquiries);

        return response;
    }
    
//    @GetMapping("/counselHistory/json")
//    @ResponseBody
//    public Map<String, Object> counselHistoryJson(@RequestParam(value = "category", required = false) String category,
//                                                  @RequestParam(value = "userNo", required = false) String userNo) {
//        List<Map<String, Object>> counselHistory;
//        System.out.println(category);
//        System.out.println(userNo);
//        if (category != null && !category.isEmpty() && userNo != null && !userNo.isEmpty()) {
//            counselHistory = inquiryService.getCounselBoard(category, userNo);
//        } else {
//            counselHistory = inquiryService.getCounselBoard("", userNo);  // 전체 데이터 가져오기
//        }
//        System.out.println("json동작확인" + counselHistory);
//        Map<String, Object> response = new HashMap<>();
//        response.put("counselHistory", counselHistory);
//        return response;
//    }

    @GetMapping("/inquiryhistory/detail/{id}")
    public ModelAndView showInquiryDetail(@PathVariable("id") int inquiryId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inquirydetail"); // inquirydetail.html로 매핑

        // inquiryId를 사용하여 해당 문의의 상세 정보를 조회
        Inquiry inquiry = inquiryService.getInquiryById(inquiryId);
        modelAndView.addObject("inquiry", inquiry);

        return modelAndView;
    }
    
    

}
