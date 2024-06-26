package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Team4.web.entity.StudentEntity;
import com.Team4.web.mongodbclass.PsyCslSurvey;
import com.Team4.web.service.PsyCslService;

import jakarta.servlet.http.HttpSession;



@Controller
public class PsyCslController {
	
	@Autowired
	PsyCslService psyCslService;
	
	@GetMapping("/psy")
	public String showPsychoPage(Model model, HttpSession session) {
		String userNo = (String) session.getAttribute("userNo");

	    if (userNo == null) {
	        model.addAttribute("isLoggedIn", false);
	        model.addAttribute("userNo", "null");
	    } else {
	        model.addAttribute("isLoggedIn", true);
	        model.addAttribute("userNo", userNo);
	    }
	    
		return "content/psycsl";
	}	
	
	
	@GetMapping("/psycslapply")
	public String psyCslApply(Model model, HttpSession session) {
		//model.addAttribute("student", psyCslService.getStudentByUserNo("5010000003"));
		
        // 세션에서 로그인한 사용자 정보 가져오기
		Object userNo = session.getAttribute("userNo");
		//System.out.println("userNo : " + userNo);
		
		if (userNo != null) {
			StudentEntity studentEntity =  psyCslService.getJpaStudentByUserNo((String) userNo);
			model.addAttribute("student", studentEntity);
			//System.out.println(studentEntity);
		} else {
			return "content/careerloginerror";
		}
		return "content/psycslapply";
	}
	
	@PostMapping("/psycslapplysubmit")
	public String psyCslApplySubmit(@RequestBody PsyCslSurvey formData) {
		System.out.println(formData);
		psyCslService.savePsyCslSurvey(formData);
		
		
	    return "redirect:/psy"; // 리다이렉트할 URL을 반환
	}
}
