package com.Team4.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Team4.web.service.ProfCslInsertService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuMovingController {
	
	@Autowired
	private ProfCslInsertService profDataLoad;
	
	@GetMapping("/test")
	public String showTestPage() {
		return "content/test";
	}
	
	@GetMapping("/")
	public String root(HttpSession httpSession, Model model) {
	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    return "index";
	}
	
	@GetMapping("/professor")
	public String showProfessorPage(HttpSession session, Model model) {
		String userNo = (String) session.getAttribute("userNo");
		if (userNo != null) {
			List<Map<String, Object>> profData = profDataLoad.profData(userNo);
			System.err.println(profData);
			model.addAttribute("profData", profData);
			model.addAttribute("userNo", userNo);
			return "content/professor";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	@GetMapping("/counselor")
	public String showCounselorPage() {
		return "counselor/counselor";
	} 
}
