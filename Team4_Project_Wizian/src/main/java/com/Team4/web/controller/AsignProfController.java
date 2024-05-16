package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.service.ProfCslInsertService;

@Controller
public class AsignProfController {
	
	@Autowired
	private ProfCslInsertService cslInsertService;
	
	@GetMapping("/profcusl")
	public String profCusl() {
		return "profcusl/professerConsultation";
	}
	
	@GetMapping("/calendar")
	public String calendar() {
		return "profcusl/calendartest";
	}
	
	
	
	
}
