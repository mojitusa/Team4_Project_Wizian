package com.Team4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyCounLogController {

	@GetMapping("myCounLog")
	public String showCounLog(){
		return "myCounLog";
	}
}
