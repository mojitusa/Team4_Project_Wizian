package com.Team4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.entity.CslScheduleEntity;
import com.Team4.web.entity.CslorEntity;
import com.Team4.web.entity.StudentEntity;
import com.Team4.web.service.NormalCslService;
import com.Team4.web.service.PsyCslService;

import jakarta.servlet.http.HttpSession;



@Controller
public class NormalCslController {
	
	@Autowired
	PsyCslService psyCslService;
	
	@Autowired
	NormalCslService normalCslService;
	
	@GetMapping("/career")
	public String showCareerPage(Model model, HttpSession session, @RequestParam(name = "page", defaultValue = "0") int page) {
		String userNo = (String) session.getAttribute("userNo");

	    if (userNo == null) {
	        model.addAttribute("isLoggedIn", false);
	        model.addAttribute("userNo", "null");
	    } else {
	        model.addAttribute("isLoggedIn", true);
	        model.addAttribute("userNo", userNo);
	        
	        List<CslorEntity> cslorEntityList =  normalCslService.getJpaCounselorByCareer();
	        
	        Pageable pageable = PageRequest.of(page, 10);  // 페이지 크기를 10으로 설정
	        Page<CslorEntity> cslorPage = normalCslService.getJpaCounselorByCareer(pageable);
	        
			model.addAttribute("counselor", cslorPage.getContent());
			model.addAttribute("page", cslorPage);
	        
	    }
	    
		return "content/career";
	}
	
	@GetMapping("/careerApplyPage")
	public String showCareerApplyPage(Model model, HttpSession session) {
	    String userNo = (String) session.getAttribute("userNo");

	    if (userNo == null) {
	        model.addAttribute("isLoggedIn", false);
	        model.addAttribute("userNo", "null");
	    } else {
	        model.addAttribute("isLoggedIn", true);
	        model.addAttribute("userNo", userNo);
	        
	        // 추가적인 비즈니스 로직이 필요하다면 여기에 추가
	    }
	    
	    return "content/careerApplyPage"; // 이 뷰 파일이 존재해야 합니다.
	}
	
	
	@GetMapping("/career2")
	public String psyCslApply(Model model, HttpSession session) {
		
        // 세션에서 로그인한 사용자 정보 가져오기
		Object userNo = session.getAttribute("userNo");
		System.out.println("userNo : " + userNo);
		
		if (userNo != null) {
			StudentEntity studentEntity =  psyCslService.getJpaStudentByUserNo((String) userNo);
			model.addAttribute("student", studentEntity);
		} else {
			 
		}
		return "content/psycslapply";
	}
	
	@GetMapping("/cslsch")
	public String cslsch() {
		
		return "content/counselorSchedule";
	}
	
	@GetMapping("/cslsch2")
	public String cslsch2() {
		
		return "content/counselorSchedule2";
	}
	
	@GetMapping("/cslsch3")
	public String cslsch3(Model model) {
		List<CslorEntity> cslorList = normalCslService.getJpaCslorByGender();
		System.out.println(cslorList);
		
		List<CslScheduleEntity> SclScheduleList = normalCslService.getJpaCslSchduleByCounselor();
		System.out.println(SclScheduleList);
		model.addAttribute("schedules", SclScheduleList);
		return "content/counselorSchedule3";
	}
	
	
	
//	@PostMapping("/psycslapplysubmit")
//	public String psyCslApplySubmit(@RequestBody PsyCslSurvey formData) {
//		psyCslService.savePsyCslSurvey(formData);
//		
//	    return "redirect:/psy"; // 리다이렉트할 URL을 반환
//	}
}
