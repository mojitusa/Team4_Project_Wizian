package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Team4.web.service.IndexService;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@GetMapping("/index")
	public String myCard(HttpSession httpSession, Model model) {
	    String secd = (String) httpSession.getAttribute("SE_CD");
	    int secdInt;

	    try {
	        secdInt = Integer.parseInt(secd);
	    } catch (NumberFormatException e) {
	        secdInt = -1; // 기본 값 또는 오류 처리 값
	    }

	    int counselCount = indexService.getCoun(secdInt);
	    model.addAttribute("isIndex", true);
	    model.addAttribute("counselCount", counselCount);
	    return "/index";
	}
}
