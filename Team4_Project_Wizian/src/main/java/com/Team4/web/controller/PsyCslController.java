package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PsyCslController {
	
	@Autowired
	//PsyCslService 
	
	@GetMapping("/psycslapply")
	public String psyCslApply() {
		
		return "content/psycslapply";
	}

}
