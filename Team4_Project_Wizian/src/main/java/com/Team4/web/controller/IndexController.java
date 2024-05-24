package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Team4.web.service.IndexService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	
	@GetMapping("/index")
	public String myCard(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("SE_CD") != null) {
			String secd = (String) httpSession.getAttribute("SE_CD");
			int secdInt;
			if (secd.equals("11")) {
				try {
					secdInt = Integer.parseInt(secd);
					int counselCount = indexService.getCoun(secdInt);
					model.addAttribute("counselCount", counselCount);
				} catch (NumberFormatException e) {
					secdInt = -1; // 기본 값 또는 오류 처리 값
				}
			}
			
		}
	    return "index";
	}
}
