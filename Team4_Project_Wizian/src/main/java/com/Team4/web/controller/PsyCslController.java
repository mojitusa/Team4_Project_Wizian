package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Team4.web.mongodbclass.PsyCslSurvey;
import com.Team4.web.service.PsyCslService;

@Controller
public class PsyCslController {
	
	@Autowired
	PsyCslService psyCslService;
	
	@GetMapping("/psycslapply")
	public String psyCslApply(Model model) {
		model.addAttribute("student", psyCslService.getStudentByUserNo("5010000003"));
		return "content/psycslapply";
	}
	
	@PostMapping("/psycslapplysubmit")
	public String psyCslApplySubmit(@RequestBody PsyCslSurvey formData) {
		psyCslService.savePsyCslSurvey(formData);
		
	    return "redirect:/psy"; // 리다이렉트할 URL을 반환
	}
}
