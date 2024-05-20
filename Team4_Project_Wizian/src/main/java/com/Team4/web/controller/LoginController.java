package com.Team4.web.controller;

import java.util.Map;

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
	private LoginService loginService;

	@PostMapping("/login")
	public String logIn(@RequestParam("user_no") String id, @RequestParam("pw") String pw, HttpSession session,  Model model) {
	    boolean loggedIn = loginService.checkLogin(id, pw);
	    if (loggedIn) {
	    	Map<String, Object> userInfo = loginService.getName(id);
            String name = (String) userInfo.get("stud_nm");
            String userNo = (String) userInfo.get("user_no");
            String studNo = (String) userInfo.get("stud_no");
            String email = (String) userInfo.get("email");
            String mbr_telno = (String) userInfo.get("mbr_telno");
            String C_NMK = (String) userInfo.get("C_NMK");
            session.setAttribute("username", name);
            session.setAttribute("userNo", userNo);
            session.setAttribute("studNo", studNo);
            session.setAttribute("email", email);
            session.setAttribute("mbr_telno", mbr_telno);
            session.setAttribute("C_NMK", C_NMK);
            System.out.println(name);
            System.out.println(userNo);
            System.out.println(email);
            System.out.println(mbr_telno);
            System.out.println(C_NMK);
            
            System.out.println(userNo);
	        return "redirect:/index";
	    } else {
	    	model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
	        return "/login";
	    }
	}
	
	@PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/index";
    }

}
