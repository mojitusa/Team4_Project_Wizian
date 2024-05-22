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
		System.out.println("usebrNo : " + userNo);

	    if (userNo == null) {
	        model.addAttribute("isLoggedIn", false);
	        
	        model.addAttribute("userNo", "null");
	        
	        System.out.println("널 조건 안으로 들어왔습니다.");
	        System.out.println("usebrNo : " + userNo);
	        return "content/careerloginerror";
	        
	    } else {
	        model.addAttribute("isLoggedIn", true);
	        model.addAttribute("userNo", userNo);
	        
	        List<CslorEntity> cslorEntityList =  normalCslService.getJpaCounselorByCareer();
	        
	        Pageable pageable = PageRequest.of(page, 10);  // 페이지 크기를 10으로 설정
	        Page<CslorEntity> cslorPage = normalCslService.getJpaCounselorByCareer(pageable);
	        
			model.addAttribute("counselor", cslorPage.getContent());
			model.addAttribute("page", cslorPage);
	        
			return "content/career";
	    }
	    
	}
	
	
	@GetMapping("/schedule999")
	public String psyCslApply(
			Model model, HttpSession session,
            @RequestParam("name") String name,
            @RequestParam("field") String field,
            @RequestParam("career") String career,
            @RequestParam("telNo") String telNo,
            @RequestParam("email") String email,
            @RequestParam("nonFace") String nonFace,
            @RequestParam("cslLoc") String cslLoc,
            @RequestParam("deptName") String deptName,
            @RequestParam("cslDetail") String cslDetail
			) {
		
        // 세션에서 로그인한 사용자 정보 가져오기
		Object userNo = session.getAttribute("userNo");
		System.out.println("userNo : " + userNo);
		System.out.println("name : " + name);
		
		
		if (userNo != null) { StudentEntity studentEntity =
		psyCslService.getJpaStudentByUserNo((String) userNo);
		model.addAttribute("student", studentEntity); }
		else { return "/"; }
		 
		return "/index";
	}
	
	@GetMapping("/cslsch")
	public String cslsch() {
		
		return "content/counselorSchedule";
	}
	
	@GetMapping("/cslsch2")
	public String cslsch2() {
		
		return "content/counselorSchedule2";
	}
	
	@GetMapping("/schedule")
	public String cslsch3(
			Model model, HttpSession session,
			@RequestParam("cslNo") String cslNo,
            @RequestParam("name") String name,
            @RequestParam("cate") String cate,
            @RequestParam("telNo") String telNo,
            @RequestParam("email") String email,
            @RequestParam("nonFace") String nonFace,
            @RequestParam("cslLoc") String cslLoc,
            @RequestParam("deptName") String deptName,
            @RequestParam("cslDetail") String cslDetail
			) {
		
		String userNo = (String) session.getAttribute("userNo");
		
		if (userNo != null) {
			StudentEntity studentEntity =
			psyCslService.getJpaStudentByUserNo((String) userNo);
			model.addAttribute("student", studentEntity);
		} else { 
			return "content/careerloginerror";
		}
		
		List<CslScheduleEntity> SclScheduleList = normalCslService.getJpaCslSchduleByCounselor(cslNo);
		model.addAttribute("schedules", SclScheduleList);
		model.addAttribute("cslNo", cslNo);
		model.addAttribute("name", name);
		model.addAttribute("cate", cate);
		model.addAttribute("telNo", telNo);
		model.addAttribute("email", email);
		model.addAttribute("nonFace", nonFace);
		model.addAttribute("cslLoc", cslLoc);
		model.addAttribute("deptName", deptName);
		model.addAttribute("cslDetail", cslDetail);
		return "content/counselorSchedule3";
	}
	
	
}
