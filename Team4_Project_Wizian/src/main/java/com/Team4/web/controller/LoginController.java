package com.Team4.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String logIn(@RequestParam("user_no") String id, @RequestParam("pw") String pw, HttpSession session, Model model) {
        boolean loggedIn = loginService.checkLogin(id, pw);
        if (loggedIn == false) {
        	model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
        	return "/login";
		}
        String userPrefix = id.substring(0, 2);
        switch (userPrefix) {
            case "10":
                return "/admin/admin";
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
            		session.setAttribute("username", name);
            		session.setAttribute("stud_no", studNo);
            		session.setAttribute("real_stud_no", realStudNo);
            		session.setAttribute("email", email);
            		session.setAttribute("mbr_telno", mbr_telno);
            		session.setAttribute("C_NMK", C_NMK);
            		session.setAttribute("ST", ST);
            		session.setAttribute("SE_CD", userPrefix);
            		return "redirect:/index";
            	} else {
            		model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
            		return "/login";
            	}
            case "12":
            	if (loggedIn && id.toString().substring(0, 2).equals("12")) {
            		Map<String, Object> userInfoPro = loginService.getInfoPro(id);
            		String PF_NO = (String) userInfoPro.get("PF_NO");
            		String PF_TELN = (String) userInfoPro.get("PF_TELNO");
            		String PF_CS_PART = (String) userInfoPro.get("PF_CS_PART");
            		String PF_CS_PART_DETAIL = (String) userInfoPro.get("PF_CS_PART_DETAIL");
            		String PF_PLC_N = (String) userInfoPro.get("PF_PLC_NM");
            		String C_CD = (String) userInfoPro.get("C_CD");
            		String PF_SC_PART = (String) userInfoPro.get("PF_SC_PART");
            		session.setAttribute("userNo", PF_NO);
            		session.setAttribute("PF_TELN", PF_TELN);
            		session.setAttribute("PF_CS_PART", PF_CS_PART);
            		session.setAttribute("PF_CS_PART_DETAIL", PF_CS_PART_DETAIL);
            		session.setAttribute("PF_PLC_N", PF_PLC_N);
            		session.setAttribute("C_CD", C_CD);
            		session.setAttribute("PF_SC_PART", PF_SC_PART);
            		session.setAttribute("SE_CD", userPrefix);
            		return "redirect:/index";
            	} else {
            		model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
            		return "/login";
            	}
            case "13":
            	if (loggedIn && id.toString().substring(0, 2).equals("13")) {
            		System.out.println("13동작홗인");
            		Map<String, Object> userInfoCoun = loginService.getInfoCounselor(id);
            		System.out.println(userInfoCoun);
            		String USER_NO = (String) userInfoCoun.get("USER_NO");
            		String C_CD = (String) userInfoCoun.get("C_CD");
            		String CSL_DETAIL = (String) userInfoCoun.get("CSL_DETAIL");
            		session.setAttribute("userNo", USER_NO);
            		session.setAttribute("PF_TELN", C_CD);
            		session.setAttribute("PF_CS_PART", CSL_DETAIL);
            		session.setAttribute("SE_CD", userPrefix);
            		return "redirect:/index";
            	} else {
            		model.addAttribute("errorMessage", "입력한 정보가 올바르지 않습니다. 다시 시도해주세요.");
            		return "/login";
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
