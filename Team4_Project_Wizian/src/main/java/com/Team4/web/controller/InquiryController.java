package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InquiryController {
	@RequestMapping(value = "/inquiry", method=RequestMethod.GET)
    public ModelAndView InquiryPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inquiry"); // inquiry.html 파일로 매핑
        // 다른 모델 데이터 추가 가능
        return modelAndView;
    }
	
	@RequestMapping(value = "/inquiry/history", method=RequestMethod.GET)
	public ModelAndView InquiryHistory(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("inquiryhistory");
		return modelAndView;
	}
}
