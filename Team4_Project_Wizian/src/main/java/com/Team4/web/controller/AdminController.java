package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Team4.web.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin")
	public String admin(HttpSession httpSession){
		Object userNoObj = httpSession.getAttribute("user_no");
        if (userNoObj == null) {
            return "redirect:/login";
        }
        
        String userNo = userNoObj.toString();
        String userNoPrefix = userNo.length() >= 2 ? userNo.substring(0, 2) : "";

        switch (userNoPrefix) {
            case "10":
                return "redirect:/admin/admin";
            case "11":
                return "redirect:/index";
            case "12":
                return "redirect:/index";
            default:
                return "redirect:/login";
        }
	}
	@GetMapping("/myProf")
	public String conselor(HttpSession httpSession, RedirectAttributes redirectAttributes){
		Object userNoObj = httpSession.getAttribute("userNo");
		System.out.println("동작확인1"+userNoObj);
        if (userNoObj == null) {
            return "/login";
        }
        
        String userNo = userNoObj.toString();
        String userNoPrefix = userNo.length() >= 2 ? userNo.substring(0, 2) : "";
        System.out.println("동작확인2"+userNoPrefix);

        if (userNoPrefix.equals("12")) {
        	System.out.println("동작확인2");
			return "/profcusl/myProf";
		} else {
			System.out.println("동작확인3");
			redirectAttributes.addFlashAttribute("message", "접근 권한이 없습니다.");
	        return "redirect:/index";
		}
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
