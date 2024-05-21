package com.Team4.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.service.ProfCslInsertService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MenuMovingController {
	
	@Autowired
	private ProfCslInsertService profDataLoad;
	
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
	
	@GetMapping("/psy")
	public String showPsychoPage() {
		return "content/psycsl";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "/login";
	}

}
