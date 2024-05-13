package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CenterController {
	@GetMapping("/center")
    public ModelAndView InquiryPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("center"); // center.html 파일로 매핑
        // 다른 모델 데이터 추가 가능
        return modelAndView;
    }
}
