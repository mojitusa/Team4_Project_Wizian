package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuMovingController {

	@GetMapping("/index")
	public String showIndexPage() {
		return "/index";
	}
	
	@GetMapping("/test")
	public String showTestPage() {
		return "content/test";
	}
	@GetMapping("/ec")
	public String showEcPage() {
		return "content/ec";
	}
	
	@GetMapping("/disability")
	public String showDisabilityPage() {
		return "content/disability";
	}
	
	@GetMapping("/sex")
	public String showSexPage() {
		return "content/sex";
	}
	
	@GetMapping("/professor")
	public String showProfessorPage() {
		return "content/professor";
	}
	
	@GetMapping("/psy")
	public String showPsychoPage(Model model, HttpSession session) {
		String userNo = (String) session.getAttribute("userNo");

	    if (userNo == null) {
	        model.addAttribute("isLoggedIn", false);
	    } else {
	        model.addAttribute("isLoggedIn", true);
	        model.addAttribute("userNo", userNo);
	    }
	    
		return "content/psycsl";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "/login";
	}
	
	@GetMapping("/myPage")
	public String showMyPage() {
		return "content/myPage";
	}
}
