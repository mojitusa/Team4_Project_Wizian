package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.service.UserRepoService;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepoService userRepoService;
	
	@PostMapping("/login")
	public String login(@RequestParam("user_no") String user_no, @RequestParam("pw") String pw) {
		
		return "redirect:/index";
	}
}
