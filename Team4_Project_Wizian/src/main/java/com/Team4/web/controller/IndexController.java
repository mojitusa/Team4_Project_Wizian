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
	    Integer secd = (Integer) httpSession.getAttribute("SE_CD");
	    if (secd == null) {
	        // SE_CD 세션 속성이 null인 경우, 기본값 설정 또는 에러 처리
	        // 여기서는 일단 기본값을 -1로 설정함
	        secd = -1;
	    }
	    System.out.println("내 " + secd);
	    
	    int counselCount = indexService.getCoun(secd.intValue());
	    System.out.println("내 " + counselCount);
	    
	    model.addAttribute("counselCount", counselCount);
	    return "/index";
	}
}
