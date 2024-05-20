package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.service.PsyCslService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {
	
	@Autowired
	private PsyCslService psyCslService;
	
	@GetMapping("/myPage")
	public String showMyPage(HttpSession httpSession) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		return "content/myPage";
	}
	@GetMapping("/myPageProF")
	public String showMyPageProf(HttpSession httpSession) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		return "content/myPageProF";
	}
	@GetMapping("/myPageCounS")
	public String showMyPageCounS(HttpSession httpSession) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		return "content/myPageCounS";
	}
	
	@GetMapping("/updatePrivacy")
	public String showMyPagePri(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		model.addAttribute("student", psyCslService.getStudentByUserNo("5010000003"));
		return "content/updatePrivacy";
	}
}
