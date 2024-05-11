package com.Team4.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.service.GroupService;

@Controller
public class groupController{
	
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
}