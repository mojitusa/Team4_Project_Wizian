package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Team4.web.entity.User;
import com.Team4.web.model.AddAccountUserModel;
import com.Team4.web.service.AddAccountUserService;
import com.Team4.web.service.UserRepoService;

@Controller
public class SignUpController {

	@Autowired
	private AddAccountUserService addAccountUserService;
	
	@Autowired
	private UserRepoService userRepoService;
	
	@GetMapping("/signUp")
	public String signUp() {
		return "/signUp";
	}
	
	
	@PostMapping("/signUp")
	public String signUpProc(User user) {
		System.out.println(user.getPw());
		
		userRepoService.doInsert(user);
		
		return "redirect:/index";
	}
}
