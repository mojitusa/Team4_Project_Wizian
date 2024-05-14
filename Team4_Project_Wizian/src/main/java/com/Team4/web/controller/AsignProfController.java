package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AsignProfController {
	
	@GetMapping("/profcusl")
	public String profCusl() {
		return "profcusl/professerConsultation";
	}
	
	@GetMapping("/calendar")
	public String calendar() {
		return "profcusl/calendartest";
	}
	
	@PostMapping("/insertProfCslData")
	public String insertProfCslData(@RequestParam("eventTime") String time) {
		System.out.println(time);
		return "profcusl/profComplite";
	}
	
	
}
