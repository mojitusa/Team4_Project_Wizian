package com.Team4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Team4.web.model.SalaryModel;
import com.Team4.web.service.SalaryService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@Autowired
	SalaryService salaryService;
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public ModelAndView goHome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		List<SalaryModel> salaryList = salaryService.getSalary();
		
		mav.addObject("salaryList", salaryList);
		mav.setViewName("content/home.html");
		
		return mav;
	}
	
    @GetMapping({"/","/list"})
    public String list(){
        return "/guestbook/list";
    }	
}

