package com.Team4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Team4.web.entity.Inquiry;
import com.Team4.web.service.InquiryService;

@Controller
public class InquiryAdminController {

    private final InquiryService inquiryService;

    @Autowired
    public InquiryAdminController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/admin/inquiries")
    public String getInquiries(Model model) {
        List<Inquiry> inquiries = inquiryService.getAllInquiries();
        model.addAttribute("inquiries", inquiries);
        return "admin/inquiries";
    }
}