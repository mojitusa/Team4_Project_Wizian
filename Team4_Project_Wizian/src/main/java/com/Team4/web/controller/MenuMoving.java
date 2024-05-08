package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuMoving {

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
	
	@GetMapping("/psycho")
	public String showPsychoPage() {
		return "content/psycho";
	}
	
	@GetMapping("/group")
	public String showGroupPage() {
		return "content/group";
	}
}
