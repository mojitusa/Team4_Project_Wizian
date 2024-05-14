package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin")
	public String admin(){
		return "/admin/admin";
	}
	
	@PostMapping("/studSignUp")
    public void signUp(@RequestParam("studentGender") String studentGender,
                       @RequestParam("studentName") String studentName,
                       @RequestParam("studentDept") String studentDept,
                       @RequestParam("studentContact") String studentContact,
                       @RequestParam("studentEmail") String studentEmail,
                       @RequestParam("studentPw") String studentPw) {
        adminService.studSignUp(studentGender, studentName, studentDept, studentContact, studentEmail, studentPw);
    }
}
