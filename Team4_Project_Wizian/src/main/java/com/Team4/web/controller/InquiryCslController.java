package com.Team4.web.controller;

import com.Team4.web.entity.InquiryCsl;
import com.Team4.web.service.InquiryCslService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InquiryCslController {

    private final InquiryCslService inquiryCslService;

    @Autowired
    public InquiryCslController(InquiryCslService inquiryCslService) {
        this.inquiryCslService = inquiryCslService;
    }

    @GetMapping("/counselor/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inquiryCsl"); // inquiryCsl.html로 매핑

        List<InquiryCsl> inquiryCsls = inquiryCslService.getAllInquiryCsls(); // 수정된 부분
        modelAndView.addObject("inquiryCsls", inquiryCsls);

        return modelAndView;
    }
    
    
}