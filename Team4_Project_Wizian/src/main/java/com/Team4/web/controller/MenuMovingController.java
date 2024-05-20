package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MenuMovingController {
	
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
	@GetMapping("/")
	public String root(HttpSession httpSession, Model model) {
	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    String requestURI = request.getRequestURI();
	    String serverName = request.getServerName();
	    System.out.println("Request URI: " + requestURI);
	    System.out.println("Server Name: " + serverName);

	    // 다음 단계로 넘어갑니다.
	    return "index";
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
	        model.addAttribute("userNo", "null");
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

}
