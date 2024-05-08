package com.Team4.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Team4.web.entity.Study;
import com.Team4.web.entity.User;
import com.Team4.web.service.StudyRepoService;
import com.Team4.web.service.UserRepoService;

@Controller
@RequestMapping("/study")
public class StudyController {
	
	@Autowired
	StudyRepoService studyRepoService;
	
	@Autowired
	UserRepoService userRepoService;
	
	@GetMapping("/list")
	public String doStudyList(Model model) {
		
//		List<Study> list = studyRepoService.doSelectAll();
		
//		model.addAttribute("list", list);
		
//		System.out.println("list다 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		System.out.println(list);
//		System.out.println("list 다 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//studyRepoService.doDelete(1);
		
//		Study study = new Study();
//		study.setContents("테스트입니다.");
//		study.setStudy_day("오늘입니다.");
//		studyRepoService.doInsert(study);
		
		//study = new Study(); 
//		list = studyRepoService.doFindById(3);
//		System.out.println("스터디 : " + list);
		
		List<User> userList = userRepoService.doSelectAll();
		System.out.println(userList);
		
		return "redirect:index";
	}

}
