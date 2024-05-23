package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.entity.StudentEntity;
import com.Team4.web.service.PsyCslService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyCounLogController {
	@Autowired
	PsyCslService psyCslService;
	@GetMapping("myCounLog")
	public String showCounLog(Model model, HttpSession session){
		
		return "myCounLog";
	}
	
}
