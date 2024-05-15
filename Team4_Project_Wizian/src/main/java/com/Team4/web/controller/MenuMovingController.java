package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.model.FileModel;

@Controller
public class MenuMovingController {

	@GetMapping("/index")
	public String showIndexPage() {
		return "/index";
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
	public String showPsychoPage() {
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
