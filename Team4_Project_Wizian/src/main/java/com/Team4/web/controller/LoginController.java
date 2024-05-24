package com.Team4.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.service.LoginService;
import com.Team4.web.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private Util util;
    @PostMapping("/login")
    public String logIn(@RequestParam("user_no") String id, @RequestParam("pw") String pw, HttpSession session, Model model) {
    	System.out.println(pw);
    	String pw2 = util.encryptSHA256(pw);
    	System.out.println(pw2);
        boolean loggedIn = loginService.checkLogin(id, pw2);
        if (loggedIn == false) {
        	model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
        	return "login";
		}
        String userPrefix = id.substring(0, 2);
        switch (userPrefix) {
            case "10":
            	session.invalidate();
                return "admin/admin";
            case "11":
            	if (loggedIn && id.toString().substring(0, 2).equals("11")) {
            		Map<String, Object> userInfo = loginService.getName(id);
            		String name = (String) userInfo.get("stud_nm");
            		String userNo = (String) userInfo.get("stud_no");
            		String realStudNo = (String) userInfo.get("real_stud_no");
            		String email = (String) userInfo.get("email");
            		String mbr_telno = (String) userInfo.get("mbr_telno");
            		String C_NMK = (String) userInfo.get("C_NMK");
            		String ST = (String) userInfo.get("ST");
            		String REAL_STUD_NO = (String) userInfo.get("REAL_STUD_NO");
            		session.setAttribute("username", name);
            		session.setAttribute("REAL_STUD_NO", REAL_STUD_NO);
            		session.setAttribute("userNo", userNo);
            		session.setAttribute("real_stud_no", realStudNo);
            		session.setAttribute("email", email);
            		session.setAttribute("mbr_telno", mbr_telno);
            		session.setAttribute("C_NMK", C_NMK);
            		session.setAttribute("ST", ST);
            		session.setAttribute("SE_CD", userPrefix);
            		return "redirect:/index";
            	} else {
            		model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
            		return "login";
            	}
            case "12":
            	if (loggedIn && id.toString().substring(0, 2).equals("12")) {
            		Map<String, Object> userInfoPro = loginService.getInfoPro(id);
            		String PF_NO = (String) userInfoPro.get("PF_NO");
            		String PF_NM = (String) userInfoPro.get("PF_NM");
            		String PF_TELNO = (String) userInfoPro.get("PF_TELNO");
            		String PF_CS_PART = (String) userInfoPro.get("PF_CS_PART");
            		String PF_CS_PART_DETAIL = (String) userInfoPro.get("PF_CS_PART_DETAIL");
            		String PF_PLC_NM = (String) userInfoPro.get("PF_PLC_NM");
            		String C_CD = (String) userInfoPro.get("C_CD");
            		session.setAttribute("userNo", PF_NO);
            		session.setAttribute("PF_NM", PF_NM);
            		session.setAttribute("PF_TELNO", PF_TELNO);
            		session.setAttribute("PF_CS_PART", PF_CS_PART);
            		session.setAttribute("PF_CS_PART_DETAIL", PF_CS_PART_DETAIL);
            		session.setAttribute("PF_PLC_NM", PF_PLC_NM);
            		session.setAttribute("C_CD", C_CD);
            		session.setAttribute("SE_CD", userPrefix);
            		return "redirect:/index";
            	} else {
            		model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
            		return "login";
            	}
            case "13":
            	if (loggedIn && id.toString().substring(0, 2).equals("13")) {
            		System.out.println("13동작홗인");
            		Map<String, Object> userInfoCoun = loginService.getInfoCounselor(id);
            		String USER_NO = (String) userInfoCoun.get("USER_NO");
            		String C_CD = (String) userInfoCoun.get("C_CD");
            		String CSL_DETAIL = (String) userInfoCoun.get("CSL_DETAIL");
            		String CAREER = (String) userInfoCoun.get("CAREER");
            		String CSLOR_NM = (String) userInfoCoun.get("CSLOR_NM");
            		String TEL_NO = (String) userInfoCoun.get("TEL_NO");
            		String CSL_LOC = (String) userInfoCoun.get("CSL_LOC");
            		String NON_FACE = (String) userInfoCoun.get("NON_FACE");
            		int ONLINE = (int) userInfoCoun.get("ONLINE");
            		String CHAT = (String) userInfoCoun.get("CHAT");
            		String ISRT_TIME = (String) userInfoCoun.get("ISRT_TIME");
            		String ISRT_IP = (String) userInfoCoun.get("ISRT_IP");
            		String UPT_TIME = (String) userInfoCoun.get("UPT_TIME");
            		String UDP_IP = (String) userInfoCoun.get("UDP_IP");
            		String DEL = (String) userInfoCoun.get("DEL");
            		String DEL_IP = (String) userInfoCoun.get("DEL_IP");
            		session.setAttribute("SE_CD", userPrefix);
            		session.setAttribute("userNo", USER_NO);
            		session.setAttribute("C_CD", C_CD);
            		session.setAttribute("CSL_DETAIL", CSL_DETAIL);
            		session.setAttribute("CAREER", CAREER);
            		session.setAttribute("CSLOR_NM", CSLOR_NM);
            		session.setAttribute("TEL_NO", TEL_NO);
            		session.setAttribute("CSL_LOC", CSL_LOC);
            		session.setAttribute("NON_FACE", NON_FACE);
            		session.setAttribute("ONLINE", ONLINE);
            		session.setAttribute("CHAT", CHAT);
            		session.setAttribute("ISRT_TIME", ISRT_TIME);
            		session.setAttribute("ISRT_IP", ISRT_IP);
            		session.setAttribute("UPT_TIME", UPT_TIME);
            		session.setAttribute("UDP_IP", UDP_IP);
            		session.setAttribute("DEL", DEL);
            		session.setAttribute("DEL_IP", DEL_IP);
            		return "redirect:/index";
            	} else {
            		model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
            		return "login";
            	}
            default:
            	model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
                return "redirect:/login";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
