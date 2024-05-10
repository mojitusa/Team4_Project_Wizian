package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ReceptionController {

    @PostMapping("/receptioncomplete")
    public ModelAndView showReceptionCompletePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("receptioncomplete"); // receptioncomplete.html 파일로 매핑
        return modelAndView;
    }
}
