package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginSerivce;

	@PostMapping("/login")
	public String logIn(@RequestParam("user_no") String id, @RequestParam("pw") String pw, HttpSession session,  Model model) {
	    boolean loggedIn = loginSerivce.checkLogin(id, pw);
	    if (loggedIn) {
	        String name = loginSerivce.getName(id);
	        session.setAttribute("username", name);
	        return "redirect:/index";
	    } else {
	    	model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
	        return "/login";
	    }
	}
	
	@PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/login";
    }

}
