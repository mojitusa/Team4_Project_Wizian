package com.Team4.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Team4.web.service.GroupService;

@Controller
public class GroupController{
	
	@Autowired
	GroupService groupService;
	
	@GetMapping("/group")
	public String showGroupPage(Model model) {
		List<Map<String, Object>> gclist = groupService.gclist();
		model.addAttribute("gclist", gclist);
		
		for (Object item : gclist) {
		    System.out.println(item);
		}
		System.out.println();
		
		return "content/group";
	}
	
	@GetMapping("/groupDetail")
	public String showGroupDetailPage(@RequestParam(value = "no", required = false, defaultValue = "") int procd, Model model) {
		
		List<Map<String, Object>> proDetail = groupService.proDetail(procd);
		model.addAttribute("proDetail", proDetail);
		
		return "content/groupDetail";
	}
	
	@GetMapping("/groupApplyPage")
	public String showGroupapplyPage(@RequestParam(value = "no", required = false, defaultValue = "") int procd, Model model) {
		
		List<Map<String, Object>> proDetail = groupService.proDetail(procd);
		model.addAttribute("proDetail", proDetail);
		
		return "content/groupApplyPage";
	}
	
	@PostMapping("/groupApplyPage")
	@ResponseBody
	public String groupapplyProgram(@RequestParam(name = "stud_no", required = false, defaultValue = "") String studNumber,
		            @RequestParam(name = "proCd", required = false, defaultValue = "") String proCode) {
		
		System.out.println("학번 : " + studNumber);
		System.out.println("프로그램 코드 : " + proCode);
		
		// 중복 검사 체크
		if(groupService.checkDuplicate(studNumber, proCode)) {
			System.out.println("중복검사가 정상적으로 작동되었습니다.");
			return "already_applied";
		}
		
		// 프로그램 신청 TB에 저장
		int result = groupService.insertApply(studNumber, proCode);
		System.out.println("결과 확인 : " + result);
		// 신청 인원 증가 코드 추가
		
		// 성공 응답 반환
		return "success";
		}

}