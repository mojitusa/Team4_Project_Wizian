package com.Team4.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.service.InquiryService;
import com.Team4.web.service.MyPageService;
import com.Team4.web.service.PsyCslService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {

	@Autowired
	private PsyCslService psyCslService;

	@Autowired
	private MyPageService myPageService;

	@Autowired
	private InquiryService inquiryService;

	@GetMapping("/myPage")
	public String showMyPage(HttpSession httpSession) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		return "content/myPage";
	}

	@GetMapping("/myPageProF")
	public String showMyPageProf(HttpSession httpSession) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		return "profcusl/myPageProF";
	}

	@GetMapping("/myPageCounS")
	public String showMyPageCounS(HttpSession httpSession) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		return "content/myPageCounS";
	}

	@GetMapping("/updatePrivacy")
	public String showMyPagePri(HttpSession httpSession, Model model) {
		if (httpSession.getAttribute("userNo") == null) {
			return "/login";
		}
		String userNo = (String) httpSession.getAttribute("userNo");
		Map<String, Object> getStudInfo = myPageService.getStudInfo(userNo);
		model.addAttribute("studInfo", getStudInfo);
		return "content/updatePrivacy";
	}

	@PostMapping("/updatePrivacy")
	public ResponseEntity<String> updatePrivacy(@RequestParam("stud_no") String studNo,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("email") String email,
			HttpSession httpSession, Model model) {
		int updated = myPageService.updatePrivacy(phoneNumber, email, studNo);
		String message;
		if (updated >= 1) {
			message = "개인 정보가 성공적으로 업데이트되었습니다.";
			System.out.println("업데이트 동작 확인1");
		} else {
			message = "프라이버시 정보 업데이트에 실패했습니다.";
			System.out.println("업데이트 동작 확인2");
		}
		return ResponseEntity.ok(message);
	}

	@PostMapping("/updatePwCheck")
	public ResponseEntity<Map<String, Boolean>> updatePwCheck(HttpSession httpSession,
			@RequestBody Map<String, String> requestBody) {
		String originalPassword = requestBody.get("originalPassword");
		String userNo = (String) httpSession.getAttribute("userNo");
		// 비밀번호 검증 로직 수행
		boolean isValid = myPageService.checkPassword(originalPassword, userNo);
		// 검증 결과를 Map에 담아 JSON 형식으로 반환
		Map<String, Boolean> response = new HashMap<>();
		response.put("valid", isValid);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/updatePw")
	@ResponseBody
	public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> requestBody,
			HttpSession httpSession) {
		String userNo = (String) httpSession.getAttribute("userNo");
		String newPassword = requestBody.get("newPassword");
		int result = myPageService.updatePw(newPassword, userNo);
		System.out.println(result);
		if (result == 1) {
			// 비밀번호 변경 성공
			return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
		} else {
			// 원래 비밀번호가 일치하지 않음
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("현재 비밀번호가 일치하지 않습니다.");
		}
	}

	@GetMapping("/counselHistory")
	@ResponseBody
	public Map<String, Object> inquiryHistoryJson(HttpSession httpSession) {
		String userNo = (String) httpSession.getAttribute("userNo");
		List<Inquiry> inquiries = myPageService.getAllBoard(userNo);
		System.out.println("counselHistory: " + inquiries);
		Map<String, Object> response = new HashMap<>();
		response.put("inquiries", inquiries);
		return response; // JSON 데이터를 직접 반환
	}
}
